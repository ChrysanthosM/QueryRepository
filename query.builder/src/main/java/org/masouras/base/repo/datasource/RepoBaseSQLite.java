package org.masouras.base.repo.datasource;

import org.masouras.base.datasource.DataSourceType;

public non-sealed interface RepoBaseSQLite extends RepoBase<DataSourceType> {
    @Override
    default DataSourceType getDataSourceType() {
        return DataSourceType.SQLITE;
    }
}
