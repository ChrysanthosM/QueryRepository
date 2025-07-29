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
@ConditionalOnProperty(name = "datasource.type.mssql", havingValue = "true")
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.masouras",
        entityManagerFactoryRef = "mssqlEntityManagerFactory",
        transactionManagerRef = "mssqlTransactionManager"
)
public class MssqlEntityManagerConfig {

    @Bean(name = "mssqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mssqlEntityManagerFactory(@Qualifier("mssqlDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("org.masouras");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPersistenceUnitName("mssqlPU");

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        factory.setJpaPropertyMap(props);

        return factory;
    }

    @Bean(name = "mssqlTransactionManager")
    public PlatformTransactionManager mssqlTransactionManager(@Qualifier("mssqlEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean(name = "mssqlEntityManager")
    public EntityManager mssqlEntityManager(@Qualifier("mssqlEntityManagerFactory") EntityManagerFactory emf) {
        return emf.createEntityManager();
    }
}

