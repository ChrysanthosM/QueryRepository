package org.masouras.core;

import jakarta.annotation.Nullable;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

final class BuildSQLWhereFilters extends BuildSQLCore {

    static BuildSQLWhereFilters createFor(SQLRetrieverForDbAbstract forSQLRetrieverForDB) { return new BuildSQLWhereFilters(forSQLRetrieverForDB); }
    private BuildSQLWhereFilters(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        List<WhereBase> whereFilters = forSQLRetrieverForDB.getWorkLInSQLBuilderParams().getWhereClauses().stream().dropWhile(Objects::isNull).toList();
        if (CollectionUtils.isEmpty(whereFilters)) return;

        List<String> whereFiltersForSQL = getResolveFiltersForSQL(forSQLRetrieverForDB, whereFilters, true);
        if (CollectionUtils.isNotEmpty(whereFiltersForSQL)) super.setStringForSQL(String.join(StringUtils.SPACE, whereFiltersForSQL));
    }

    static String getWhereFilters(String basicFilters) { return getWhereFiltersWithJoins(basicFilters, null); }
    static String getWhereFiltersWithJoins(String basicFilters, @Nullable String joinFilters) {
        if (StringUtils.isBlank(basicFilters) && StringUtils.isBlank(joinFilters)) return StringUtils.EMPTY;
        StringBuilder builder = new StringBuilder("WHERE ");
        if (StringUtils.isBlank(basicFilters)) {
            builder.append(joinFilters);
        } else {
            builder.append(basicFilters);
            if (StringUtils.isNotBlank(joinFilters)) builder.append("AND (").append(joinFilters.trim()).append(")");
        }
        return builder.toString();
    }


    static String getResolveFilterForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB, WhereBase whereFilter, boolean resetFirstOperator) { return getResolveFiltersForSQL(forSQLRetrieverForDB, List.of(whereFilter), resetFirstOperator).getFirst(); }
    static List<String> getResolveFiltersForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB, List<WhereBase> whereFilters, boolean resetFirstOperator) {
        whereFilters.stream().filter(w -> ((FilterBase) w).getTypeOfLogicalOperator() == null).forEach(w -> ((FilterBase) w).setTypeOfLogicalOperator(LinSQL.TypeOfLogicalOperator.AND));
        if (resetFirstOperator) ((FilterBase) whereFilters.getFirst()).setTypeOfLogicalOperator(null);

        return whereFilters.stream()
                .map(where -> ((ResolveObjectForSQLBase) where).getResolveObjectForSQL(forSQLRetrieverForDB))
                .filter(StringUtils::isNotBlank)
                .toList();
    }
}
