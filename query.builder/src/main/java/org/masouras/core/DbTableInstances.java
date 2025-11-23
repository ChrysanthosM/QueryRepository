package org.masouras.core;

import jakarta.annotation.PostConstruct;
import org.masouras.base.builder.BaseDbTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DbTableInstances {
    private static final Map<BaseDbTable, DbTable> mapTableInstances = new ConcurrentHashMap<>();
    static DbTable getInstance(BaseDbTable forDbT) {
        return mapTableInstances.getOrDefault(forDbT, null);
    }

    private final List<DbTableBase> implementations;

    @Autowired
    private DbTableInstances(List<DbTableBase> implementations) {
        this.implementations = List.copyOf(implementations);
    }

    @PostConstruct
    public void init() {
        this.implementations.parallelStream().forEach(dbT -> mapTableInstances.put(((DbTable) dbT).getBaseDbTable(), (DbTable) dbT));
    }
}
