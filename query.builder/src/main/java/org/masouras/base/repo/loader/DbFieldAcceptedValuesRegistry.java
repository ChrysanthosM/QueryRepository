package org.masouras.base.repo.loader;

import lombok.experimental.UtilityClass;
import org.masouras.base.builder.BaseDbField;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public final class DbFieldAcceptedValuesRegistry {
    private static final Map<String, List<String>> registry = new ConcurrentHashMap<>();

    public static void put(String key, List<String> values) {
        registry.put(key, values);
    }

    public static List<String> get(BaseDbField field) {
        String fullPathKey = field.getClass().getCanonicalName() + "." + field.getName();
        return registry.getOrDefault(fullPathKey, List.of());
    }
}

