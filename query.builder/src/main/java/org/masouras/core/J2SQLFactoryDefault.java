package org.masouras.core;

import org.masouras.base.datasource.DataSourceType;
import org.springframework.stereotype.Component;

@Component
public class J2SQLFactoryDefault implements J2SQLFactory {
    @Override
    public J2SQL create(DataSourceType dataSourceType) {
        return J2SQL.create(dataSourceType);
    }
}
