package org.masouras;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataSourceTypeFilter implements TypeFilter {
    private static final Set<String> DATASOURCE_PACKAGES = Set.of("sqlite", "db2i", "mssql");

    @Override
    public boolean match(MetadataReader metadataReader, @NotNull MetadataReaderFactory metadataReaderFactory) {
        String className = metadataReader.getClassMetadata().getClassName();
        String dataSourceType = System.getProperty("datasource.type",
                System.getenv().getOrDefault("DATASOURCE_TYPE", "sqlite"));

        if (!className.startsWith("org.masouras.")) {
            return false;
        }

        String packageAfterBase = className.substring("org.masouras.".length());
        int firstDotIndex = packageAfterBase.indexOf('.');
        if (firstDotIndex == -1) {
            return false;
        }

        String subPackage = packageAfterBase.substring(0, firstDotIndex);
        if (!DATASOURCE_PACKAGES.contains(subPackage)) {
            return false;
        }

        boolean shouldExclude = !subPackage.equals(dataSourceType.toLowerCase());
        System.out.println("Package: " + subPackage + " - Exclude: " + shouldExclude);
        return shouldExclude;
    }
}
