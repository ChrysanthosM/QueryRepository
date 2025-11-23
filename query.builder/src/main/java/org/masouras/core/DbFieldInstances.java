package org.masouras.core;

import jakarta.annotation.PostConstruct;
import org.masouras.base.builder.BaseDbField;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DbFieldInstances {
    private static final Map<BaseDbField, DbField> mapFieldInstances = new ConcurrentHashMap<>();
    static DbField getInstance(BaseDbField forDbF) {
        return mapFieldInstances.getOrDefault(forDbF, null);
    }

    @PostConstruct
    public void init() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(Scanners.SubTypes));

        Set<Class<? extends BaseDbField>> implementations = reflections.getSubTypesOf(BaseDbField.class);
        implementations.stream()
                .filter(Class::isEnum)
                .flatMap(enumClass -> Arrays.stream(enumClass.getEnumConstants()))
                .map(BaseDbField.class::cast)
                .parallel()
                .forEach(f -> mapFieldInstances.put(f, new DbField(f)));
    }
}
