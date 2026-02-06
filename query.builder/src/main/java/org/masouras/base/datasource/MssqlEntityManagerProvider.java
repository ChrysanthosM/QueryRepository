package org.masouras.base.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "datasource.type.mssql", havingValue = "true")
public class MssqlEntityManagerProvider {

    @PersistenceContext(unitName = "mssqlPU")
    private EntityManager entityManager;

    public EntityManager get() {
        return entityManager;
    }
}
