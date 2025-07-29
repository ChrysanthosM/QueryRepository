package org.masouras.base.datasource;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerResolver {
    private @Autowired @Qualifier("sqliteEntityManager") ObjectProvider<EntityManager> sqliteEntityManager;
    private @Autowired @Qualifier("mssqlEntityManager") ObjectProvider<EntityManager> mssqlEntityManager;
    private @Autowired @Qualifier("db2iEntityManager") ObjectProvider<EntityManager> db2iEntityManager;

    public EntityManager getEntityManager(DataSourceType type) {
        return switch (type) {
            case SQLITE -> sqliteEntityManager.getIfAvailable();
            case MSSQL -> mssqlEntityManager.getIfAvailable();
            case DB2_I -> db2iEntityManager.getIfAvailable();
        };
    }
}
