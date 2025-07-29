package org.masouras.base.datasource;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.masouras.base.datasource.provider.DataSourceProvider;
import org.masouras.base.datasource.provider.DataSourceResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class WorkWithDataSource {
    @Value("${datasource.type}")
    private String datasourceType;

    private final DataSourceResolver dataSourceResolver;
    @Getter
    private DataSourceProvider defaultDataSourceProvider;

    public WorkWithDataSource(DataSourceResolver dataSourceResolver) {
        this.dataSourceResolver = dataSourceResolver;
    }

    @PostConstruct
    private void init() {
        defaultDataSourceProvider = dataSourceResolver.getWorkWithDataSource(DataSourceType.getByPropertyName(datasourceType));
    }
}
