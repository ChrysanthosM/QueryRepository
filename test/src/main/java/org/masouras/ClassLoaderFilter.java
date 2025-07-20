package org.masouras;

import org.jetbrains.annotations.NotNull;
import org.masouras.base.datasource.WorkWithDataSource;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClassLoaderFilter implements TypeFilter, EnvironmentAware {
    private static final String BASE_PACKAGE = ClassLoaderFilter.class.getPackageName();

    private static final Set<String> DATASOURCE_PACKAGES = Arrays.stream(WorkWithDataSource.DataSourceType.values())
            .map(WorkWithDataSource.DataSourceType::getPropertyName)
            .collect(Collectors.toSet());

    private Environment environment;
    @Override
    public void setEnvironment(@NotNull Environment environment) {
        this.environment = environment;
    }

    @Override
    public boolean match(MetadataReader metadataReader, @NotNull MetadataReaderFactory metadataReaderFactory) {
        String className = metadataReader.getClassMetadata().getClassName();
        String dataSourceType = environment != null ? environment.getProperty("datasource.type") : null;
        if (dataSourceType == null) {
            return false;
        }

        if (!className.startsWith(BASE_PACKAGE + ".")) {
            return false;
        }

        String packageAfterBase = className.substring((BASE_PACKAGE + ".").length());
        int firstDotIndex = packageAfterBase.indexOf('.');
        if (firstDotIndex == -1) {
            return false;
        }

        String subPackage = packageAfterBase.substring(0, firstDotIndex);
        if (!DATASOURCE_PACKAGES.contains(subPackage)) {
            return false;
        }

        return !subPackage.equals(dataSourceType.toLowerCase());
    }
}
