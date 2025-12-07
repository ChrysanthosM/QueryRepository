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
@ConditionalOnProperty(name = "datasource.type.sqlite", havingValue = "true")
public non-sealed class SqliteConfig implements BaseConfig {
    @Value("${sqlite.url:#{null}}")
    private String sqliteUrl;

    @Bean(name = "sqliteDataSource")
    @Override
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(sqliteUrl);
        return dataSource;
    }

    @Bean(name = "sqliteJdbcTemplate")
    @Override
    public JdbcTemplate getJdbcTemplate(@Qualifier("sqliteDataSource") DataSource sqliteDataSource) {
        return new JdbcTemplate(sqliteDataSource);
    }
}

