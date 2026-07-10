package org.masouras.base.datasource.config;

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
@ConditionalOnProperty(name = "datasource.type.maria", havingValue = "true")
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.masouras",
        entityManagerFactoryRef = "mariaEntityManagerFactory",
        transactionManagerRef = "mariaTransactionManager"
)
public non-sealed class MariaEntityManagerConfig implements BaseEntityManagerConfig {

    @Bean(name = "mariaEntityManagerFactory")
    @Override
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(@Qualifier("mariaDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("org.masouras");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPersistenceUnitName("mariaPU");

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        props.put("hibernate.hbm2ddl.auto", "none");
        props.put("spring.sql.init.mode", "never");
        factory.setJpaPropertyMap(props);

        return factory;
    }

    @Bean(name = "mariaTransactionManager")
    @Override
    public PlatformTransactionManager getPlatformTransactionManager(@Qualifier("mariaEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}

