package org.masouras.base.repo.datasource;

import org.masouras.base.datasource.DataSourceType;

public non-sealed interface RepoBaseMSSQL extends RepoBase<DataSourceType> {
    @Override
    default DataSourceType getDataSourceType() {
        return DataSourceType.MSSQL;
    }
}
