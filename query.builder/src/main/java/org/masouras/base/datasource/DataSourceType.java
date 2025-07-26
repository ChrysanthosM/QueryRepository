package org.masouras.base.datasource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataSourceType {
    SQLITE("sqlite", null),
    MSSQL("mssql", null),
    DB2_I("db2i", "$."),
    ;
    private final String propertyName;
    private final String tablePrefixToReplace;

    public static DataSourceType getByPropertyName(String propertyName) {
        for (DataSourceType type : values()) {
            if (type.propertyName.equalsIgnoreCase(propertyName)) return type;
        }
        throw new IllegalArgumentException("No enum constant with property name " + propertyName);
    }
}
