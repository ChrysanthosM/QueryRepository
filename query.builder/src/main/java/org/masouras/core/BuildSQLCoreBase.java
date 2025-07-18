package org.masouras.core;

sealed interface BuildSQLCoreBase permits BuildSQLCore {
    String getStringForSQL();
    void setStringForSQL(String setString);
}
