package org.masouras.base.datasource.provider;

import javax.sql.DataSource;
import java.util.Optional;

public abstract sealed class AbstractDataSourceProvider implements DataSourceProvider
        permits DataSourceProviderForDB2i, DataSourceProviderForMSSQL, DataSourceProviderForSQLite {

    protected final Optional<DataSource> optionalDataSource;

    protected AbstractDataSourceProvider(Optional<DataSource> optionalDataSource) {
        this.optionalDataSource = optionalDataSource;
    }

    @Override
    public DataSource getDS() {
        return optionalDataSource.orElseThrow(() -> new IllegalStateException("DataSource not configured"));
    }
}
