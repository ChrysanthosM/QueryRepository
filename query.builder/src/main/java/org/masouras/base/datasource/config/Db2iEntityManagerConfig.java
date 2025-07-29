package org.masouras.base.datasource.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(name = "datasource.type.db2i", havingValue = "true")
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.masouras",
        entityManagerFactoryRef = "db2iEntityManagerFactory",
        transactionManagerRef = "db2iTransactionManager"
)
public class Db2iEntityManagerConfig {

    @Bean(name = "db2iEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db2iEntityManagerFactory(@Qualifier("db2iDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("org.masouras");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPersistenceUnitName("db2iPU");

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.DB2400Dialect");
        factory.setJpaPropertyMap(props);

        return factory;
    }

    @Bean(name = "db2iTransactionManager")
    public PlatformTransactionManager db2iTransactionManager(@Qualifier("db2iEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean(name = "db2iEntityManager")
    public EntityManager db2iEntityManager(@Qualifier("db2iEntityManagerFactory") EntityManagerFactory emf) {
        return emf.createEntityManager();
    }
}

