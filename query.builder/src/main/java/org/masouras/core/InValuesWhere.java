package org.masouras.core;

import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


final class InValuesWhere extends AbstractWhere {
    @Override TypeOfWhere getTypeOfWhere() { return TypeOfWhere.WHERE_IN_VALUES; }

    private final List<Object> inValues;

    InValuesWhere(@NonNull Object whereObject, @NonNull List<Object> inValues) {
        super(whereObject);
        this.inValues = inValues;
    }

    @Override
    public String getResolveObjectForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        StringBuilder returnValue = new StringBuilder(super.whereObjectForSQL(forSQLRetrieverForDB));

        if (CollectionUtils.isNotEmpty(this.inValues)) {
            List<String> newInValues = this.inValues.stream()
                    .filter(Objects::nonNull)
                    .flatMap(o -> ResolveSqlUserSelection
                            .getSqlUserSelection(o, super.getInQuotesRequirement())
                            .stream()
                            .map(sel -> sel.getResolveObjectForSQL(forSQLRetrieverForDB)))
                    .toList();
            returnValue.append(newInValues.stream().collect(Collectors.joining(", ", "(", ")")));
        }

        returnValue.append(super.resolveAttachedFilters(forSQLRetrieverForDB));
        return returnValue.append(super.resolveParenthesisRight()).toString();
    }
}
