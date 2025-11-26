package org.masouras.base.repo.base;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.datasource.EntityManagerResolver;
import org.masouras.core.J2SQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public abstract class AbstractJ2<E extends Enum<E>> {
    private static final int LOAD_TIMEOUT = 10; // seconds

    @Getter(AccessLevel.PRIVATE) private final Class<E> nameOfSQL;
    private final DataSourceType dataSourceType;

    private final Map<E, J2SQL> bufferJ2SQLs = new ConcurrentHashMap<>();
    private final Map<E, String> bufferSQLs = new ConcurrentHashMap<>();
    private final Deque<Pair<E, CompletableFuture<J2SQL>>> loadBuffers = new ConcurrentLinkedDeque<>();

    private EntityManager entityManager;
    private @Autowired EntityManagerResolver entityManagerResolver;

    protected AbstractJ2(Class<E> nameOfSQL, DataSourceType dataSourceType) {
        this.nameOfSQL = nameOfSQL;
        this.dataSourceType = dataSourceType;
    }

    public J2SQL getJ2SQL(E nameOfSQL) { return bufferJ2SQLs.getOrDefault(nameOfSQL, null); }
    public String getSQL(E nameOfSQL) { return bufferSQLs.getOrDefault(nameOfSQL, null); }
    public <T> Query getNativeQuery(E nameOfSQL, Class<T> resultClass) { return entityManager.createNativeQuery(bufferSQLs.getOrDefault(nameOfSQL, null), resultClass); }
    public Query getNativeQuery(E nameOfSQL) { return entityManager.createNativeQuery(bufferSQLs.getOrDefault(nameOfSQL, null)); }

    @PostConstruct
    private void init() {
        this.entityManager = entityManagerResolver.getEntityManager(dataSourceType);

        long startLoadingTime = System.currentTimeMillis();
        load();
        if (log.isInfoEnabled()) log.info("{} loaded in {}", this.getClass().getSimpleName(), System.currentTimeMillis() - startLoadingTime);
    }
    private void load() {
        loadBuffers();
        awaitLoaders();
    }
    private void loadBuffers() {
        List<Method> loaders = Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(LoadJ2SQL.class))
                .toList();
        if (CollectionUtils.isNotEmpty(loaders)) {
            loaders.parallelStream().forEach(this::invokeThis);
        }
    }
    private void invokeThis(Method m) {
        try {
            m.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    protected void addLoader(E nameOfSQL, J2SQL j2SQL) { loadBuffers.add(Pair.of(nameOfSQL, CompletableFuture.supplyAsync(() -> j2SQL))); }

    private void awaitLoaders() {
        if (loadBuffers.isEmpty()) return;

        List<CompletableFuture<Void>> tasks = loadBuffers.stream()
                .map(pair -> CompletableFuture.runAsync(() -> {
                    try {
                        J2SQL j2sql = pair.getRight().get(LOAD_TIMEOUT, TimeUnit.SECONDS);
                        bufferJ2SQLs.put(pair.getLeft(), j2sql);
                        bufferSQLs.put(pair.getLeft(), j2sql.getSQL());
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        throw new CompletionException(e);
                    }
                }))
                .toList();
        try {
            CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();
        } catch (CompletionException e) {
            throw new RuntimeException("Error loading SQL buffers", e.getCause());
        } finally {
            loadBuffers.clear();
        }
    }
}
