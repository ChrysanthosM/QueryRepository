package org.masouras.core;

import com.google.common.base.Preconditions;
import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.masouras.base.builder.BaseDbField;
import org.masouras.base.builder.BaseDbTable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class SQLFieldFromTable extends SqlUserSelection {
    @Override public Type getTypeOfSelection() { return this.getClass(); }

    private BaseDbField dbF;
    private DbField dbField = null;

    SQLFieldFromTable(@NonNull BaseDbField dbF) {
        super();
        init(null, null, dbF);
    }
    SQLFieldFromTable(@NonNull BaseDbField dbF, @Nullable String asAlias) {
        super();
        init(null, asAlias, dbF);
    }
    SQLFieldFromTable(@NonNull BaseDbField dbF, @Nullable String asAlias, @Nullable String setPrefix) {
        super();
        init(setPrefix, asAlias, dbF);
    }
    @Override public void init(@Nullable String setPrefix, @Nullable String asAlias, @Nullable Object... args) {
        Preconditions.checkNotNull(args);
        Preconditions.checkElementIndex(0, args.length);
        Preconditions.checkNotNull(args[0]);
        Preconditions.checkArgument(args[0] instanceof BaseDbField);
        this.dbF = (BaseDbField) args[0];
        this.dbField = DbFieldInstances.getInstance(this.dbF);
        super.setHasPrefix(setPrefix);
        super.setAsAlias(asAlias);
    }

    BaseDbField getDbFieldEnum() { return this.dbF; }

    @Override public String getResolveObjectForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        return getResolveObjectForSQLMain(forSQLRetrieverForDB, null);
    }

    String getResolveObjectForSQLMain(SQLRetrieverForDbAbstract forSQLRetrieverForDB, @Nullable BaseDbTable forDbt) {
        String returnName = buildBaseReturnName(forSQLRetrieverForDB, forDbt);

        if (hasNoExplicitPrefix()) {
            returnName = addTablePrefix(returnName, forSQLRetrieverForDB);
        }

        setAutoAliasIfNeeded(forSQLRetrieverForDB);

        return LinSQLCommons.applyAsAlias(returnName, super.getAsAlias(), false, false);
    }

    private String buildBaseReturnName(SQLRetrieverForDbAbstract forSQLRetrieverForDB, @Nullable BaseDbTable forDbt) {
        String prefix = StringUtils.defaultString(this.getHasPrefix());
        if (this.dbF == BaseDbField.all()) {
            return prefix.concat(LinSQLCommons.ASTERISK);
        }

        String tablePrefix = getTablePrefixForFields(forDbt);
        String fieldName = getFieldName(forSQLRetrieverForDB);
        return prefix.concat(tablePrefix).concat(fieldName);
    }

    private String getTablePrefixForFields(@Nullable BaseDbTable forDbt) {
        return forDbt == null
                ? StringUtils.EMPTY
                : StringUtils.defaultString(forDbt.getTablePrefix());
//                StringUtils.defaultString(DbTableInstances.getInstance(forDbt).getTablePrefixForFields());
    }

    private String getFieldName(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        return forSQLRetrieverForDB.getTypeOfNamingSystemOrNormalized() == LinSQL.TypeOfNamingSystemOrNormalized.SYSTEM
                ? this.dbField.getDbfSystemName()
                : this.dbField.getDbfNormalName();
    }

    private boolean hasNoExplicitPrefix() {
        return StringUtils.isBlank(this.getHasPrefix());
    }

    private String addTablePrefix(String returnName, SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        String tableAlias = findAppropriateTableAlias(forSQLRetrieverForDB);
        return StringUtils.isNotBlank(tableAlias) ?
                tableAlias.concat(".").concat(returnName) :
                returnName;
    }

    private String findAppropriateTableAlias(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        String defaultAlias = StringUtils.defaultString(forSQLRetrieverForDB.getWorkLInSQLBuilderParams().getWorkWithTableOnlyAsAlias());

        Set<Triple<DbTable, String, List<BaseDbField>>> availableTables = forSQLRetrieverForDB.getAvailableTablesWithFields();
        if (CollectionUtils.isEmpty(availableTables)) {
            return defaultAlias;
        }
        return findTableContainingField(availableTables, defaultAlias);
    }

    private String findTableContainingField(Set<Triple<DbTable, String, List<BaseDbField>>> availableTables, String defaultAlias) {
        for (Triple<DbTable, String, List<BaseDbField>> table : new ArrayList<>(availableTables).reversed()) {
            if (tableContainsField(table)) {
                return table.getMiddle();
            }
        }
        return defaultAlias;
    }

    private boolean tableContainsField(Triple<DbTable, String, List<BaseDbField>> table) {
        List<BaseDbField> fields = table.getRight();
        return CollectionUtils.isNotEmpty(fields) && fields.contains(this.dbField.getDbfNameEnum());
    }

    private void setAutoAliasIfNeeded(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        if (shouldApplyAutoAlias(forSQLRetrieverForDB)) {
            super.setAsAlias(this.dbField.getDbfAsAlias());
        }
    }

    private boolean shouldApplyAutoAlias(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        return this.dbF != BaseDbField.all() &&
                StringUtils.isBlank(super.getAsAlias()) &&
                forSQLRetrieverForDB.getWorkLInSQLBuilderParams().isApplyAutoAlias() &&
                !super.isIgnoreTableAsAlias();
    }
}
