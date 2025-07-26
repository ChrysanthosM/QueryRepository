package org.masouras.base.datasource;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WorkWithDataSource {
    @Value("${datasource.type}")
    private String datasourceType;

    private final DataSourceResolver dataSourceResolver;
    @Getter
    private DataSourceType defaultDataSourceType;
    @Getter
    private DataSourceProvider defaultDataSourceProvider;

    public WorkWithDataSource(DataSourceResolver dataSourceResolver) {
        this.dataSourceResolver = dataSourceResolver;
    }

    @PostConstruct
    private void init() {
        defaultDataSourceType = DataSourceType.getByPropertyName(datasourceType);
        defaultDataSourceProvider = dataSourceResolver.getDefaultDataSource(defaultDataSourceType);
    }
}
