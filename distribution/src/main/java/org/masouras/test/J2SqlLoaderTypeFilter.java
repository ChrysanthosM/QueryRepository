package org.masouras.test;

import org.jetbrains.annotations.NotNull;
import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.repo.datasource.RepoBase;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class J2SqlLoaderTypeFilter implements TypeFilter {
    private final Environment environment;
    private final ApplicationContext applicationContext;

    public J2SqlLoaderTypeFilter(Environment environment, ApplicationContext applicationContext) {
        this.environment = environment;
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean match(MetadataReader metadataReader, @NotNull MetadataReaderFactory metadataReaderFactory) {
        String className = metadataReader.getClassMetadata().getClassName();
        try {
            Class<?> clazz = Class.forName(className);
            if (!clazz.isAnnotationPresent(J2SqlLoader.class)) return false;
            if (!RepoBase.class.isAssignableFrom(clazz)) return false;

            RepoBase<?> repo = (RepoBase<?>) applicationContext.getBean(clazz);
            String key = "datasource.type." + repo.getDataSourceType().getPropertyName();
            return Boolean.parseBoolean(environment.getProperty(key, "false"));
        } catch (Exception e) {
            return false;
        }
    }
}
