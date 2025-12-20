package org.masouras.core;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

abstract sealed class WhenThen implements WhenBase, ResolveObjectForSQLBase
        permits WhenThenSearched, WhenThenSimple {

    private final Object thenExpression;
    @Setter private Boolean inQuotesRequirement;

    protected WhenThen(Object thenExpression) {
        this.thenExpression = thenExpression;
    }

    protected String getThen(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        String resolved = ResolveSqlUserSelection.getSqlUserSelection(this.thenExpression, this.inQuotesRequirement).stream()
                .map(sel -> sel.getResolveObjectForSQL(forSQLRetrieverForDB))
                .collect(Collectors.joining(StringUtils.SPACE));
        return " THEN " + resolved;
    }
}
