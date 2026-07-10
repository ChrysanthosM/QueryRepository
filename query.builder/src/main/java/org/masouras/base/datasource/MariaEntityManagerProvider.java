package org.masouras.base.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "datasource.type.maria", havingValue = "true")
public class MariaEntityManagerProvider {

    @PersistenceContext(unitName = "mariaPU")
    private EntityManager entityManager;

    public EntityManager get() {
        return entityManager;
    }
}
