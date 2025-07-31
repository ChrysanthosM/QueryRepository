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
@ConditionalOnProperty(name = "datasource.type.mssql", havingValue = "true")
public non-sealed class MssqlConfig implements BaseConfig {
    @Value("${mssql.url:null}")
    private String mssqlUrl;

    @Value("${mssql.username:null}")
    private String mssqlUsername;
    @Value("${mssql.password:null}")
    private String mssqlPassword;

    @Bean(name = "mssqlDataSource")
    @Override
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(mssqlUrl);
        dataSource.setUsername(mssqlUsername);
        dataSource.setPassword(mssqlPassword);
        return dataSource;
    }

    @Bean(name = "mssqlJdbcTemplate")
    @Override
    public JdbcTemplate getJdbcTemplate(@Qualifier("mssqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

