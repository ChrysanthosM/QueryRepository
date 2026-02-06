package org.masouras.base.datasource;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerResolver {

    @Autowired(required = false)
    private SqliteEntityManagerProvider sqliteProvider;

    @Autowired(required = false)
    private MssqlEntityManagerProvider mssqlProvider;

    @Autowired(required = false)
    private Db2iEntityManagerProvider db2iProvider;

    public EntityManager getEntityManager(DataSourceType type) {
        return switch (type) {
            case SQLITE -> sqliteProvider != null ? sqliteProvider.get() : null;
            case MSSQL -> mssqlProvider != null ? mssqlProvider.get() : null;
            case DB2_I -> db2iProvider != null ? db2iProvider.get() : null;
        };
    }
}
