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
            case SQLITE -> {
                if (sqliteProvider == null) throw new IllegalStateException("SQLite datasource is not enabled (datasource.type.sqlite=true is missing).");
                yield sqliteProvider.get();
            }
            case MSSQL -> {
                if (mssqlProvider == null) throw new IllegalStateException("MSSQL datasource is not enabled (datasource.type.mssql=true is missing).");
                yield mssqlProvider.get();
            }
            case DB2_I -> {
                if (db2iProvider == null) throw new IllegalStateException("DB2_I datasource is not enabled (datasource.type.db2i=true is missing).");
                yield db2iProvider.get();
            }
        };
    }
}
