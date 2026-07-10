package org.masouras.base.datasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(name = "datasource.type.maria", havingValue = "true")
public non-sealed class MariaConfig implements BaseConfig {
    @Value("${maria.url:#{null}}")
    private String mariaUrl;

    @Value("${maria.username:#{null}}")
    private String mariaUsername;
    @Value("${maria.password:#{null}}")
    private String mariaPassword;

    @Bean(name = "mariaDataSource")
    @Override
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(mariaUrl);
        dataSource.setUsername(mariaUsername);
        dataSource.setPassword(mariaPassword);
        return dataSource;
    }

    @Bean(name = "mariaJdbcTemplate")
    @Override
    public JdbcTemplate getJdbcTemplate(@Qualifier("mariaDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

