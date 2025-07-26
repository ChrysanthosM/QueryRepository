package org.masouras.base.repo;

import org.masouras.base.datasource.DataSourceType;

public non-sealed interface RepoBaseDB2i extends RepoBase<DataSourceType> {
    @Override
    default DataSourceType getDataSourceType() {
        return DataSourceType.DB2_I;
    }
}
