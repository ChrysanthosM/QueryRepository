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
public class SqliteConfig {
    @Value("${sqlite.url:null}")
    private String sqliteUrl;

    @Bean(name = "sqliteDataSource")
    public DataSource sqliteDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(sqliteUrl);
        return dataSource;
    }

    @Bean(name = "sqliteJdbcTemplate")
    public JdbcTemplate sqliteJdbcTemplate(@Qualifier("sqliteDataSource") DataSource sqliteDataSource) {
        return new JdbcTemplate(sqliteDataSource);
    }
}

