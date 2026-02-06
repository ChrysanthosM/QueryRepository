package org.masouras.base.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "datasource.type.db2i", havingValue = "true")
public class Db2iEntityManagerProvider {

    @PersistenceContext(unitName = "db2iPU")
    private EntityManager entityManager;

    public EntityManager get() {
        return entityManager;
    }
}
