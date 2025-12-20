package org.masouras.core;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.stream.Collectors;

final class BetweenValuesWhere extends AbstractWhere {
    @Override TypeOfWhere getTypeOfWhere() { return TypeOfWhere.WHERE_BETWEEN; }

    private final Pair<Object, Object> betweenValues;

    BetweenValuesWhere(@NonNull Object whereObject, @NonNull Pair<Object, Object> betweenValues) {
        super(whereObject);
        this.betweenValues = betweenValues;
    }

    @Override
    public String getResolveObjectForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        String leftSql = ResolveSqlUserSelection.getSqlUserSelection(this.betweenValues.getLeft(), super.getInQuotesRequirement())
                .stream()
                .map(sel -> sel.getResolveObjectForSQL(forSQLRetrieverForDB))
                .collect(Collectors.joining(StringUtils.SPACE));
        String rightSql = ResolveSqlUserSelection.getSqlUserSelection(this.betweenValues.getRight(), super.getInQuotesRequirement())
                .stream()
                .map(sel -> sel.getResolveObjectForSQL(forSQLRetrieverForDB))
                .collect(Collectors.joining(StringUtils.SPACE));

        return super.whereObjectForSQL(forSQLRetrieverForDB)
                + leftSql
                + " AND "
                + rightSql
                + super.resolveAttachedFilters(forSQLRetrieverForDB)
                + super.resolveParenthesisRight();
    }
}
