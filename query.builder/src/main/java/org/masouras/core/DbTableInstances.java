package org.masouras.core;

import jakarta.annotation.PostConstruct;
import org.masouras.base.builder.BaseDbTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DbTableInstances {
    private static final Map<BaseDbTable, DbTable> mapTableInstances = new ConcurrentHashMap<>();
    private final List<DbTableBase> implementations;

    @Autowired
    private DbTableInstances(List<DbTableBase> implementations) {
        this.implementations = List.copyOf(implementations);
    }
    @PostConstruct
    public void init() {
        this.implementations.parallelStream().forEach(dbT -> mapTableInstances.put(((DbTable) dbT).getBaseDbTable(), (DbTable) dbT));
    }


    static DbTable getInstance(BaseDbTable forDbT) {
        return mapTableInstances.getOrDefault(forDbT, null);
    }
}
