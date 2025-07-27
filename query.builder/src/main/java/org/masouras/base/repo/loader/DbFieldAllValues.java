package org.masouras.base.repo.loader;

import lombok.experimental.UtilityClass;
import org.masouras.base.builder.BaseDbField;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public final class DbFieldAllValues {
    public record DbFieldKey(String sourceId, BaseDbField field) {}
    private static final Map<DbFieldKey, List<String>> registry = new ConcurrentHashMap<>();

    public static void put(DbFieldKey key, List<String> values) {
        registry.put(key, values);
    }

    public static List<String> get(String sourceId, BaseDbField field) {
        return registry.getOrDefault(new DbFieldKey(sourceId, field), List.of());
    }

    public static Map<DbFieldKey, List<String>> all() {
        return Collections.unmodifiableMap(registry);
    }
}

