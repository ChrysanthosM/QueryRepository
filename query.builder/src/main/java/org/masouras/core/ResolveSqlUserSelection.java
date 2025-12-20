package org.masouras.core;

import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;
import org.masouras.base.builder.BaseDbField;

import java.util.List;

@UtilityClass
class ResolveSqlUserSelection {
    static List<SqlUserSelection> getSqlUserSelection(Object selectionObject) {
        return getSqlUserSelectionMain(selectionObject, null, null);
    }
    static List<SqlUserSelection> getSqlUserSelection(Object selectionObject, String asAlias) {
        return getSqlUserSelectionMain(selectionObject, asAlias, null);
    }
    static List<SqlUserSelection> getSqlUserSelection(Object selectionObject, Boolean inQuotesRequirement) {
        return getSqlUserSelectionMain(selectionObject, null, inQuotesRequirement);
    }

    private static List<SqlUserSelection> getSqlUserSelectionMain(Object selectionObject, String asAlias, Boolean inQuotesRequirement) {
        return switch (selectionObject) {
            case SQLFieldOperation op -> List.of(op);
            case SQLFieldObject obj -> List.of(obj);
            case SQLFieldFromTable table -> List.of(table);
            case SQLFieldFromPairOfTableField pair -> List.of(pair);
            case BaseDbField dbf -> List.of(new SQLFieldFromTable(dbf, asAlias));
            case PairOfTableField pair -> List.of(new SQLFieldFromPairOfTableField(pair, asAlias));

            case List<?> list when CollectionUtils.isNotEmpty(list) ->
                    list.stream()
                            .filter(SQLFieldFromPairOfTableField.class::isInstance)
                            .map(SQLFieldFromPairOfTableField.class::cast)
                            .map(p -> (SqlUserSelection) p)
                            .toList();

            case J2SQLShared.SQLFunctionObject stringsFunction -> {
                ((SQLFunction) stringsFunction.getSqlFunction()).setAsAlias(asAlias);
                yield List.of(((SQLFunction) stringsFunction.getSqlFunction()));
            }
            default -> List.of(new SQLFieldFromConstant(selectionObject, asAlias, inQuotesRequirement));
        };
    }
}
