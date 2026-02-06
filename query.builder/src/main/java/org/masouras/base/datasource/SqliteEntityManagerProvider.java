package org.masouras.base.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "datasource.type.sqlite", havingValue = "true")
public class SqliteEntityManagerProvider {

    @PersistenceContext(unitName = "sqlitePU")
    private EntityManager entityManager;

    public EntityManager get() {
        return entityManager;
    }
}
