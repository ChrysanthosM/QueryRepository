package org.masouras.base.datasource.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

sealed interface BaseEntityManagerConfig
        permits Db2iEntityManagerConfig, MssqlEntityManagerConfig, SqliteEntityManagerConfig {
    LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(DataSource dataSource);
    PlatformTransactionManager getPlatformTransactionManager(EntityManagerFactory emf);
    EntityManager getEntityManager(EntityManagerFactory emf);
}
