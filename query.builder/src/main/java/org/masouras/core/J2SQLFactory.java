package org.masouras.core;

import org.masouras.base.datasource.DataSourceType;

public interface J2SQLFactory {
    J2SQL create(DataSourceType dataSourceType);
}
