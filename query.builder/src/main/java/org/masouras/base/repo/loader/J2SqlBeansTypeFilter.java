package org.masouras.base.repo.loader;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.core.env.Environment;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

public final class J2SqlBeansTypeFilter implements TypeFilter {
    private final Environment environment;
    private final Set<Class<? extends Annotation>> scanAnnotations;

    public J2SqlBeansTypeFilter(Environment environment, Set<Class<? extends Annotation>> scanAnnotations) {
        this.environment = environment;
        this.scanAnnotations = scanAnnotations;
    }

    @Override
    public boolean match(MetadataReader metadataReader, @NotNull MetadataReaderFactory metadataReaderFactory) {
        String className = metadataReader.getClassMetadata().getClassName();
        try {
            Class<?> clazz = Class.forName(className);

            for (Class<? extends Annotation> ann : scanAnnotations) {
                Annotation annotation = clazz.getAnnotation(ann);
                if (annotation != null) {
                    String suffix = getValueFromAnnotationOrNull(annotation);
                    if (suffix != null) {
                        String key = "datasource.type." + suffix;
                        return Boolean.parseBoolean(environment.getProperty(key, "false"));
                    }
                }
            }
        } catch (ClassNotFoundException ignored) { }

        return false;
    }

    private @Nullable String getValueFromAnnotationOrNull(Annotation annotation) {
        try {
            Method method = annotation.annotationType().getMethod("value");
            Object result = method.invoke(annotation);
            return result != null ? result.toString() : null;
        } catch (Exception e) {
            return null;
        }
    }
}


