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
@ConditionalOnProperty(name = "datasource.type.db2i", havingValue = "true")
public class Db2iConfig {
    @Value("${db2i.url:null}")
    private String db2iUrl;

    @Value("${db2i.username:null}")
    private String db2iUsername;
    @Value("${db2i.password:null}")
    private String db2iPassword;

    @Bean(name = "db2iDataSource")
    public DataSource db2iDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(db2iUrl);
        dataSource.setUsername(db2iUsername);
        dataSource.setPassword(db2iPassword);
        return dataSource;
    }

    @Bean(name = "db2iJdbcTemplate")
    public JdbcTemplate db2iJdbcTemplate(@Qualifier("db2iDataSource") DataSource db2iDataSource) {
        return new JdbcTemplate(db2iDataSource);
    }
}

