package org.masouras.test;

import org.jetbrains.annotations.NotNull;
import org.masouras.base.datasource.DataSourceType;
import org.springframework.core.env.Environment;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class DistributionTypeFilter implements TypeFilter {
    private static final String BASE_PACKAGE = DistributionTypeFilter.class.getPackageName();
    private static final Set<String> DATASOURCE_PACKAGES = Arrays.stream(DataSourceType.values())
            .map(DataSourceType::getPropertyName)
            .map(String::toLowerCase)
            .collect(Collectors.toSet());

    private final Environment environment;
    public DistributionTypeFilter(Environment environment) {
        this.environment = environment;
    }

    @Override
    public boolean match(MetadataReader metadataReader, @NotNull MetadataReaderFactory metadataReaderFactory) {
        String className = metadataReader.getClassMetadata().getClassName();
        if (!className.startsWith(BASE_PACKAGE + ".")) return false;

        String packageAfterBase = className.substring((BASE_PACKAGE + ".").length());
        int firstDotIndex = packageAfterBase.indexOf('.');
        if (firstDotIndex == -1) return false;

        String subPackage = packageAfterBase.substring(0, firstDotIndex);
        if (!DATASOURCE_PACKAGES.contains(subPackage)) return false;

        return Boolean.parseBoolean(environment.getProperty("datasource.type." + subPackage, "false"));
    }
}

