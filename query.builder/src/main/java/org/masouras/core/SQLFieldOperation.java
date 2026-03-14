package org.masouras.core;

import jakarta.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

final class SQLFieldOperation extends SqlUserSelection {
    @Override public Type getTypeOfSelection() { return this.getClass(); }

    private Object object;
    private String operation;

    SQLFieldOperation(Object object, String operation) {
        super();
        init(null, operation, object);
    }
    @Override public void init(@Nullable String setPrefix, @Nullable String expression, @Nullable Object... args) {
        Objects.requireNonNull(args);
        this.object = args[0];
        this.operation = expression;
    }

    @Override
    public String getResolveObjectForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB) {
        List<String> resolved = ResolveSqlUserSelection.getSqlUserSelection(this.object, false).stream()
                .map(sel -> {
                    String keepAlias = sel.getAsAlias();
                    sel.setAsAlias(null);
                    sel.setIgnoreTableAsAlias();
                    return sel.getResolveObjectForSQL(forSQLRetrieverForDB)
                            + StringUtils.SPACE
                            + LinSQLCommons.asAliasMain(keepAlias)
                            + StringUtils.SPACE
                            + this.operation;
                })
                .toList();

        return String.join(StringUtils.SPACE, resolved);
    }

}
