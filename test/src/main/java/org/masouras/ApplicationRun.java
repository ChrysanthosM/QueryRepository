package org.masouras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
        basePackages = "org.masouras",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = DataSourceTypeFilter.class)
        }
)
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
