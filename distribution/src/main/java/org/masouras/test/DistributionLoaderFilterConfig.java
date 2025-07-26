package org.masouras.test;

import org.jetbrains.annotations.NotNull;
import org.masouras.base.datasource.DataSourceType;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class DistributionLoaderFilterConfig implements TypeFilter, EnvironmentAware {
    private static final String BASE_PACKAGE = DistributionLoaderFilterConfig.class.getPackageName();

    private static final Set<String> DATASOURCE_PACKAGES = Arrays.stream(DataSourceType.values())
            .map(DataSourceType::getPropertyName)
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
            return false; // Don't exclude if no datasource configured
        }

        if (!className.startsWith(BASE_PACKAGE + ".")) {
            return false; // Don't exclude classes outside our package
        }

        String packageAfterBase = className.substring((BASE_PACKAGE + ".").length());
        int firstDotIndex = packageAfterBase.indexOf('.');
        if (firstDotIndex == -1) {
            return false; // Don't exclude if not in a sub-package
        }

        String subPackage = packageAfterBase.substring(0, firstDotIndex);
        if (!DATASOURCE_PACKAGES.contains(subPackage)) {
            return false; // Don't exclude if not a datasource package
        }

        // EXCLUDE classes that are NOT for the current datasource
        return !subPackage.equals(dataSourceType.toLowerCase());
    }
}
