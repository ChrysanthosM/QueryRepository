package org.masouras.test;

import org.jetbrains.annotations.NotNull;
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
import java.util.Set;

@Configuration
public class SuffixBeanRegistry implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {
    private static final String BASE_PACKAGE = DistributionTypeFilter.class.getPackageName();
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
        scanner.addIncludeFilter(new DistributionTypeFilter(environment));

        for (BeanDefinition candidate : scanner.findCandidateComponents(BASE_PACKAGE)) {
            String className = candidate.getBeanClassName();
            if (className == null || !className.startsWith(BASE_PACKAGE + ".")) continue;
            try {
                Class<?> clazz = Class.forName(className);
                if (scanAnnotations.stream().noneMatch(clazz::isAnnotationPresent)) continue;

                String packageAfterBase = className.substring(BASE_PACKAGE.length() + 1);
                int dotIndex = packageAfterBase.indexOf('.');
                if (dotIndex == -1) continue;

                String subPackage = packageAfterBase.substring(0, dotIndex);
                if (subPackage.isEmpty()) continue; // Guard against malformed sub-package

                String baseBeanName = Introspector.decapitalize(clazz.getSimpleName());
                String beanName = baseBeanName + "_" + subPackage;

                GenericBeanDefinition definition = new GenericBeanDefinition();
                definition.setBeanClass(clazz);
                registry.registerBeanDefinition(beanName, definition);
            } catch (ClassNotFoundException e) {
                throw new BeansException("Failed to load class: " + className, e) {};
            }
        }
    }

    @Override
    public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) {
        // No additional processing needed here
    }
}

