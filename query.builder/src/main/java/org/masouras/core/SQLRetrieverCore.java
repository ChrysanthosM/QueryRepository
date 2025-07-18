package org.masouras.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.masouras.base.builder.BaseDbField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

abstract sealed class SQLRetrieverCore implements DeployMethodsBase, DeploySQLStatementsBase, DeploySQLFunctionsBase
        permits SQLRetrieverForDbAbstract {
    protected abstract String getDbPrefixForTableLocation();
    protected abstract LinSQL.TypeOfNamingSystemOrNormalized getTypeOfNamingSystemOrNormalized();

    //initSQLStatement
    @Getter @Setter(AccessLevel.PROTECTED) private BuildSQLWorkTable workBuildSQLWorkTable = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLSelectFields workBuildSQLSelectFields = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLWhereFilters workBuildSQLWhereFilters = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLOrderBy workBuildSQLOrderBy = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLGroupByHavingValues workBuildSQLGroupByHavingValues = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLJoinWith workBuildSQLJoinWith = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLUnionWith workBuildSQLUnionWith = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLUpdateFields workBuildSQLUpdateFields = null;
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private BuildSQLInsertRows workBuildSQLInsertRows = null;

    @Getter private final Set<Triple<DbTable, String, List<BaseDbField>>> availableTablesWithFields = new HashSet<>();
    void addAvailableTableWithFields(Triple<DbTable, String, List<BaseDbField>> tableWithFields) { this.availableTablesWithFields.add(tableWithFields); }
    void addAvailableTableWithFields(Set<Triple<DbTable, String, List<BaseDbField>>> tablesWithFields) { this.availableTablesWithFields.addAll(tablesWithFields); }
    protected void clearAvailableTablesWithFields() { this.availableTablesWithFields.clear(); }

    @Getter private final List<String> fieldMapper = new ArrayList<>();
    void addFieldMapper(String fieldMapper) { this.fieldMapper.add(fieldMapper); }
    protected void clearFieldMapper() { this.fieldMapper.clear(); }

    private static void initSQLStatementCommons(SQLRetrieverForDbAbstract initSQLRetrieverForDB) {
        initSQLRetrieverForDB.setWorkBuildSQLWorkTable(null);
        initSQLRetrieverForDB.setWorkBuildSQLSelectFields(null);
        initSQLRetrieverForDB.setWorkBuildSQLWhereFilters(null);
        initSQLRetrieverForDB.setWorkBuildSQLOrderBy(null);
        initSQLRetrieverForDB.setWorkBuildSQLGroupByHavingValues(null);
        initSQLRetrieverForDB.setWorkBuildSQLJoinWith(null);
        initSQLRetrieverForDB.setWorkBuildSQLUnionWith(null);
        initSQLRetrieverForDB.setWorkBuildSQLUpdateFields(null);
        initSQLRetrieverForDB.setWorkBuildSQLInsertRows(null);

        initSQLRetrieverForDB.clearAvailableTablesWithFields();
        initSQLRetrieverForDB.clearFieldMapper();

        initSQLRetrieverForDB.setWorkBuildSQLWorkTable(BuildSQLWorkTable.createFor(initSQLRetrieverForDB));
    }

    protected static InitializationStatus initSQLStatementForSelect(SQLRetrieverForDbAbstract initSQLRetrieverForDB) {
        try {
            initSQLStatementCommons(initSQLRetrieverForDB);
            initSQLRetrieverForDB.setWorkBuildSQLSelectFields(BuildSQLSelectFields.createFor(initSQLRetrieverForDB));
            initSQLRetrieverForDB.setWorkBuildSQLWhereFilters(BuildSQLWhereFilters.createFor(initSQLRetrieverForDB));
            initSQLRetrieverForDB.setWorkBuildSQLOrderBy(BuildSQLOrderBy.createFor(initSQLRetrieverForDB));
            initSQLRetrieverForDB.setWorkBuildSQLGroupByHavingValues(BuildSQLGroupByHavingValues.createFor(initSQLRetrieverForDB));
            initSQLRetrieverForDB.setWorkBuildSQLJoinWith(BuildSQLJoinWith.createFor(initSQLRetrieverForDB));
            initSQLRetrieverForDB.setWorkBuildSQLUnionWith(BuildSQLUnionWith.createFor(initSQLRetrieverForDB));
            return InitializationStatus.returnOK();
        } catch (Exception e) {
            return InitializationStatus.returnException(e);
        }
    }
    protected static InitializationStatus initSQLStatementForDelete(SQLRetrieverForDbAbstract initSQLRetrieverForDB) {
        try {
            initSQLStatementCommons(initSQLRetrieverForDB);
            initSQLRetrieverForDB.setWorkBuildSQLWhereFilters(BuildSQLWhereFilters.createFor(initSQLRetrieverForDB));
            initSQLRetrieverForDB.setWorkBuildSQLOrderBy(BuildSQLOrderBy.createFor(initSQLRetrieverForDB));
            return InitializationStatus.returnOK();
        } catch (Exception e) {
            return InitializationStatus.returnException(e);
        }
    }
    protected static InitializationStatus initSQLStatementForUpdate(SQLRetrieverForDbAbstract initSQLRetrieverForDB) {
        try {
            initSQLStatementCommons(initSQLRetrieverForDB);
            initSQLRetrieverForDB.setWorkBuildSQLUpdateFields(BuildSQLUpdateFields.createFor(initSQLRetrieverForDB));
            initSQLRetrieverForDB.setWorkBuildSQLWhereFilters(BuildSQLWhereFilters.createFor(initSQLRetrieverForDB));
            return InitializationStatus.returnOK();
        } catch (Exception e) {
            return InitializationStatus.returnException(e);
        }
    }
    protected static InitializationStatus initSQLStatementForInsert(SQLRetrieverForDbAbstract initSQLRetrieverForDB) {
        try {
            initSQLStatementCommons(initSQLRetrieverForDB);
            initSQLRetrieverForDB.setWorkBuildSQLInsertRows(BuildSQLInsertRows.createFor(initSQLRetrieverForDB));
            return InitializationStatus.returnOK();
        } catch (Exception e) {
            return InitializationStatus.returnException(e);
        }
    }


    protected static class InitializationStatus {
        enum ReturnSts { OK, ERROR_EXISTS }

        private final ReturnSts sts;
        private String msg = StringUtils.EMPTY;
        private Exception exc = null;

        private InitializationStatus(ReturnSts setSts) {
            this.sts = setSts;
        }
        private InitializationStatus(ReturnSts setSts, String setMsg) {
            this.sts = setSts;
            this.msg = setMsg;
        }
        private InitializationStatus(ReturnSts setSts, Exception setExc) {
            this.sts = setSts;
            this.exc = setExc;
        }
        protected ReturnSts getSts() {
            return this.sts;
        }
        protected String getMsg() {
            return this.msg;
        }
        protected Exception getExc() {
            return this.exc;
        }

        protected static InitializationStatus returnOK() {
            return new InitializationStatus(ReturnSts.OK);
        }
        protected static InitializationStatus returnError(String setMsg) {
            return new InitializationStatus(ReturnSts.ERROR_EXISTS, setMsg);
        }
        protected static InitializationStatus returnException(Exception setExc) {
            return new InitializationStatus(ReturnSts.ERROR_EXISTS, setExc);
        }
    }


}
