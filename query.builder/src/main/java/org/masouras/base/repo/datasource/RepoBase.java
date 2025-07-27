package org.masouras.base.repo.datasource;

sealed interface RepoBase<DataSourceType extends Enum<DataSourceType>>
        permits RepoBaseDB2i, RepoBaseMSSQL, RepoBaseSQLite {
    DataSourceType getDataSourceType();

    @SuppressWarnings("unchecked")
    default <T extends Enum<T>> T[] getSupportedQueries() {
        Class<?> implementingClass = this.getClass();

        Class<?>[] nestedClasses = implementingClass.getDeclaredClasses();
        for (Class<?> nestedClass : nestedClasses) {
            if (nestedClass.isEnum()) {
                return (T[]) nestedClass.getEnumConstants();
            }
        }

        throw new IllegalStateException("No nested enum found in " + implementingClass.getName());
    }
}

