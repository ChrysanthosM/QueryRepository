package org.masouras.base.datasource.config;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

sealed interface BaseConfig
        permits Db2iConfig, MssqlConfig, SqliteConfig {
    DataSource getDataSource();
    JdbcTemplate getJdbcTemplate(DataSource dataSource);
}
