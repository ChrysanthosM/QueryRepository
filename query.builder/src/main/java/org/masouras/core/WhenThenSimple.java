package org.masouras.core;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

final class WhenThenSimple extends WhenThen {
    private final Object whenCondition;

    WhenThenSimple(@NonNull Object whenCondition, @Nullable Object thenExpression) {
        super(thenExpression);
        this.whenCondition = whenCondition;
    }

    @Override
    public String getResolveObjectForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        String whenClause = ResolveSqlUserSelection.getSqlUserSelection(this.whenCondition).stream()
                .map(sel -> sel.getResolveObjectForSQL(forSQLRetrieverForDB))
                .collect(Collectors.joining(StringUtils.SPACE));
        return "WHEN " + whenClause + super.getThen(forSQLRetrieverForDB);
    }
}
