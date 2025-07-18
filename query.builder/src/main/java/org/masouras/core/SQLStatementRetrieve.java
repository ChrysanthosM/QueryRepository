package org.masouras.core;

import lombok.Getter;
import org.masouras.base.datasource.WorkWithDataSource;

@Getter
final class SQLStatementRetrieve {
    private final SQLRetrieverForDbAbstract sqlRetrieverForDB;
    SQLStatementRetrieve(WorkWithDataSource.DataSourceType typeOfDB,
                         LinSQL.TypeOfNamingSystemOrNormalized typeOfNamingSystemOrNormalized,
                         String dbPrefixForTable) {
        switch (typeOfDB) {
            case SQLITE -> this.sqlRetrieverForDB = new SQLRetrieverForDbSQLite(typeOfNamingSystemOrNormalized);
            case DB2_I -> this.sqlRetrieverForDB = new SQLRetrieverForDbDB2i(typeOfNamingSystemOrNormalized, dbPrefixForTable);
            case MSSQL -> this.sqlRetrieverForDB = new SQLRetrieverForDbMSSQL(typeOfNamingSystemOrNormalized, dbPrefixForTable);
            default -> throw new UnsupportedOperationException(typeOfDB + " is not supported");
        }
    }

    void setWorkLInSQLBuilderParams(LInSQLBuilderParams workLInSQLBuilderParams) { this.sqlRetrieverForDB.setWorkLInSQLBuilderParams(workLInSQLBuilderParams); }

    BuildSQLWorkTable getWorkBuildSQLWorkTable() { return this.sqlRetrieverForDB.getWorkBuildSQLWorkTable(); }
    BuildSQLJoinWith getWorkBuildSQLJoinWith() { return this.sqlRetrieverForDB.getWorkBuildSQLJoinWith(); }
    BuildSQLSelectFields getWorkBuildSQLSelectFields() { return this.sqlRetrieverForDB.getWorkBuildSQLSelectFields(); }
    BuildSQLWhereFilters getWorkBuildSQLWhereFilters() { return this.sqlRetrieverForDB.getWorkBuildSQLWhereFilters(); }
    BuildSQLOrderBy getWorkBuildSQLOrderBy() { return this.sqlRetrieverForDB.getWorkBuildSQLOrderBy(); }
    BuildSQLGroupByHavingValues getWorkBuildSQLGroupByHavingValues() { return this.sqlRetrieverForDB.getWorkBuildSQLGroupByHavingValues(); }

    String getSQLStatementForSelect() { return this.sqlRetrieverForDB.getSQLStatementForSelect().concat(this.sqlRetrieverForDB.createComments(this.sqlRetrieverForDB.getWorkLInSQLBuilderParams().getComments())); }
    String getSQLStatementForDelete() { return this.sqlRetrieverForDB.getSQLStatementForDelete().concat(this.sqlRetrieverForDB.createComments(this.sqlRetrieverForDB.getWorkLInSQLBuilderParams().getComments())); }
    String getSQLStatementForUpdate() { return this.sqlRetrieverForDB.getSQLStatementForUpdate().concat(this.sqlRetrieverForDB.createComments(this.sqlRetrieverForDB.getWorkLInSQLBuilderParams().getComments())); }
    String getSQLStatementForInsert() { return this.sqlRetrieverForDB.getSQLStatementForInsert().concat(this.sqlRetrieverForDB.createComments(this.sqlRetrieverForDB.getWorkLInSQLBuilderParams().getComments())); }
    String getSQLStatementForInsertGetOnlyValues() { return this.sqlRetrieverForDB.getSQLStatementForInsertGetOnlyValues().concat(this.sqlRetrieverForDB.createComments(this.sqlRetrieverForDB.getWorkLInSQLBuilderParams().getComments())); }

}
