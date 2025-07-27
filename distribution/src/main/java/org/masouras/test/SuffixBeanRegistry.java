package org.masouras.test;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.masouras.base.annotation.J2SqlFieldValues;
import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.annotation.J2SqlTable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

@Configuration
public class SuffixBeanRegistry implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {
    private static final Set<Class<? extends Annotation>> scanAnnotations = Set.of(
            J2SqlLoader.class,
            J2SqlService.class,
            J2SqlFieldValues.class,
            J2SqlTable.class
    );

    private Environment environment;

    @Override
    public void setEnvironment(@NotNull Environment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(@NotNull BeanDefinitionRegistry registry) throws BeansException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new J2SqlBeansTypeFilter(environment, scanAnnotations));

        for (BeanDefinition candidate : scanner.findCandidateComponents("org.masouras")) {
            String className = candidate.getBeanClassName();
            if (className == null) continue;

            try {
                Class<?> clazz = Class.forName(className);
                if (scanAnnotations.stream().noneMatch(clazz::isAnnotationPresent)) continue;

                String baseBeanName = Introspector.decapitalize(clazz.getSimpleName());
                String annotationSuffix = extractSuffixFromAnnotations(clazz);
                String newBeanName = StringUtils.isBlank(annotationSuffix) ? baseBeanName : baseBeanName + "_" + annotationSuffix;

                GenericBeanDefinition definition = new GenericBeanDefinition();
                definition.setBeanClass(clazz);
                registry.registerBeanDefinition(newBeanName, definition);
            } catch (ClassNotFoundException e) {
                throw new BeansException("Failed to load class: " + className, e) {};
            }
        }
    }

    private @Nullable String extractSuffixFromAnnotations(Class<?> clazz) {
        for (Class<? extends Annotation> annClass : scanAnnotations) {
            Annotation ann = clazz.getAnnotation(annClass);
            if (ann != null) {
                try {
                    Method valueMethod = annClass.getMethod("value");
                    Object value = valueMethod.invoke(ann);
                    if (value != null && !value.toString().isBlank()) {
                        return value.toString();
                    }
                } catch (Exception ignored) { }
            }
        }
        return null;
    }

    @Override
    public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) {
        // No post-factory logic needed
    }
}


