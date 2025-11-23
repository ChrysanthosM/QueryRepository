package org.masouras.base.repo.loader;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.masouras.base.annotation.J2SqlFieldValues;
import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.annotation.J2SqlTable;
import org.masouras.base.builder.BaseDbField;
import org.masouras.core.ValueForBase;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import java.beans.Introspector;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@Slf4j
public class J2SqlBeansRegistry implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {
    private static final Set<Class<? extends Annotation>> createBeanAnnotations = Set.of(
            J2SqlLoader.class,
            J2SqlService.class,
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
        Set<Class<? extends Annotation>> extendedAnnotations = Stream.concat(
                createBeanAnnotations.stream(),
                Stream.of(J2SqlFieldValues.class)
        ).collect(Collectors.toUnmodifiableSet());
        scanner.addIncludeFilter(new J2SqlBeansTypeFilter(environment, extendedAnnotations));

        List<Class<?>> createBeanClasses = new ArrayList<>();
        Map<String, List<String>> acceptedFieldValues = new HashMap<>();
        for (BeanDefinition candidate : scanner.findCandidateComponents(getGroupId())) {
            String className = candidate.getBeanClassName();
            if (className == null) continue;

            try {
                Class<?> clazz = Class.forName(className);
                if (createBeanAnnotations.stream().anyMatch(clazz::isAnnotationPresent)) createBeanClasses.add(clazz);
                if (clazz.isAnnotationPresent(J2SqlFieldValues.class)) processFieldValues(clazz, acceptedFieldValues);
            } catch (ClassNotFoundException | NoClassDefFoundError e) {
                log.error("Skipping invalid class: {}", className, e);
            }
        }
        createBeanClasses.forEach(clazz -> registerJ2Bean(registry, clazz));
        acceptedFieldValues.forEach(DbFieldAcceptedValuesRegistry::put);
    }


    private void processFieldValues(Class<?> clazz, Map<String, List<String>> collectedFieldValues) {
        for (Class<?> innerClass : clazz.getDeclaredClasses()) {
            if (innerClass.isEnum() && ValueForBase.class.isAssignableFrom(innerClass)) {
                for (Object constant : innerClass.getEnumConstants()) {
                    ValueForBase vfb = (ValueForBase) constant;
                    String value = vfb.getValue();
                    BaseDbField dbField = vfb.getForDbField();

                    if (value != null && dbField != null) {
                        String key = dbField.getClass().getCanonicalName() + "." + dbField.getName();
                        collectedFieldValues.merge(key, List.of(value), (existing, incoming) -> {
                            Set<String> merged = new LinkedHashSet<>(existing);
                            merged.addAll(incoming);
                            return List.copyOf(merged);
                        });
                    }
                }
            }
        }
    }


    private void registerJ2Bean(@NotNull BeanDefinitionRegistry registry, Class<?> clazz) {
        String baseBeanName = Introspector.decapitalize(clazz.getSimpleName());
        String suffix = extractSuffixFromAnnotations(clazz);
        String newBeanName = (suffix == null || suffix.isBlank()) ? baseBeanName : baseBeanName + "_" + suffix;

        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(clazz);
        registry.registerBeanDefinition(newBeanName, definition);
    }


    private String getGroupId() {
        try (InputStream input = getClass().getResourceAsStream("/application.properties")) {
            Properties props = new Properties();
            props.load(input);
            return props.getProperty("groupId");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private @Nullable String extractSuffixFromAnnotations(Class<?> clazz) {
        for (Class<? extends Annotation> annClass : createBeanAnnotations) {
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


