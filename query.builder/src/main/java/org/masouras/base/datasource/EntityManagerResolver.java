package org.masouras.base.datasource;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerResolver {
    private final ObjectProvider<EntityManager> sqliteEntityManager;
    private final ObjectProvider<EntityManager> mssqlEntityManager;
    private final ObjectProvider<EntityManager> db2iEntityManager;

    @Autowired
    public EntityManagerResolver(@Qualifier("sqliteEntityManager") ObjectProvider<EntityManager> sqliteEntityManager,
                                 @Qualifier("mssqlEntityManager") ObjectProvider<EntityManager> mssqlEntityManager,
                                 @Qualifier("db2iEntityManager") ObjectProvider<EntityManager> db2iEntityManager) {
        this.sqliteEntityManager = sqliteEntityManager;
        this.mssqlEntityManager = mssqlEntityManager;
        this.db2iEntityManager = db2iEntityManager;
    }

    public EntityManager getEntityManager(DataSourceType type) {
        return switch (type) {
            case SQLITE -> sqliteEntityManager.getIfAvailable();
            case MSSQL -> mssqlEntityManager.getIfAvailable();
            case DB2_I -> db2iEntityManager.getIfAvailable();
        };
    }
}
