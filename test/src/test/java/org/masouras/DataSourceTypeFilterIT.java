package org.masouras;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

@Component
public class DataSourceTypeFilterIT implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, @NotNull MetadataReaderFactory metadataReaderFactory) {
        String className = metadataReader.getClassMetadata().getClassName();
        String dataSourceType = System.getProperty("datasource.type", System.getenv().getOrDefault("DATASOURCE_TYPE", "sqlite"));

        if (!className.startsWith("org.masouras.")) {
            return false;
        }

        String packageAfterBase = className.substring("org.masouras.".length());
        int firstDotIndex = packageAfterBase.indexOf('.');
        if (firstDotIndex == -1) {
            return false;
        }

        String subPackage = packageAfterBase.substring(0, firstDotIndex);
        return !subPackage.equals(dataSourceType.toLowerCase());
    }
}
