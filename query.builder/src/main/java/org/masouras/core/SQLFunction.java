package org.masouras.core;

import com.google.common.base.Preconditions;
import jakarta.annotation.Nullable;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract sealed class SQLFunction extends SqlUserSelection
        permits SQLFunction1Param, SQLFunction2Params, SQLFunction3Params,
        SQLFunctionAggregates, SQLFunctionAggregatesWithPossibleALL,
        SQLFunctionCASE, SQLFunctionCONCAT, SQLFunctionTRANSLATE {
    static final String NON_SUPPORTED_MSG = "Non Supported Method";

    @Override public Type getTypeOfSelection() { return this.getClass(); }
    abstract DeploySQLFunctionsBase.TypeOfSQLFunction getTypeOfSQLFunction();

    private List<Object> params = new ArrayList<>();
    protected List<Object> getParams() { return this.params; }
    protected Object getParam() { return this.params.getFirst(); }
    protected void setParams(List<Object> params) { this.params = params; }
    protected void addParam(Object param) { this.params.add(param); }
    private List<String> paramsSelectedFieldForSQL = null;

    protected List<String> getParamsSelectedFieldForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB, @Nullable Boolean inQuotesRequirement) {
        if (CollectionUtils.isNotEmpty(this.paramsSelectedFieldForSQL)) return this.paramsSelectedFieldForSQL;
        this.paramsSelectedFieldForSQL = this.params.stream()
                .filter(Objects::nonNull)
                .flatMap(arg -> ResolveSqlUserSelection.getSqlUserSelection(arg, inQuotesRequirement).stream()
                        .map(sel -> sel.getResolveObjectForSQL(forSQLRetrieverForDB)))
                .toList();
        return this.paramsSelectedFieldForSQL;
    }
    protected String getFirstParamSelectedFieldForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB, @Nullable Boolean inQuotesRequirement) {
        return ResolveSqlUserSelection.getSqlUserSelection(this.params.getFirst(), inQuotesRequirement).stream()
                .map(sel -> sel.getResolveObjectForSQL(forSQLRetrieverForDB))
                .collect(Collectors.joining(StringUtils.SPACE));
    }
    protected String getLastParamSelectedFieldForSQL(SQLRetrieverForDbAbstract forSQLRetrieverForDB, @Nullable Boolean inQuotesRequirement) {
        return ResolveSqlUserSelection.getSqlUserSelection(this.params.getLast(), inQuotesRequirement).stream()
                .map(sel -> {
                    sel.setIgnoreTableAsAlias();
                    return sel.getResolveObjectForSQL(forSQLRetrieverForDB);
                })
                .collect(Collectors.joining(StringUtils.SPACE));
    }

    abstract String defaultResolver(SQLRetrieverForDbAbstract forSQLRetrieverForDB);
    abstract String alternateResolver(SQLRetrieverForDbAbstract forSQLRetrieverForDB, @Nullable Object... args);

    protected String resolverAllParamsInParenthesis(SQLRetrieverForDbAbstract forSQLRetrieverForDB, DeploySQLFunctionsBase.TypeOfSQLFunction typeOfSQLFunction) {
        List<?> workParams = getParamsSelectedFieldForSQL(forSQLRetrieverForDB, null);
        String result = workParams.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", typeOfSQLFunction.name() + "(", ")"));
        return getFinalValueAsAlias(result, getAsAlias());
    }

    @Override public void init(@Nullable String setPrefix, @Nullable String asAlias, @Nullable Object... args) {
        Preconditions.checkNotNull(args);
        Stream.of(args).filter(Objects::nonNull).forEach(arg -> this.params.add(arg));
        super.setAsAlias(asAlias);
        super.setHasPrefix(setPrefix);
    }

    protected static String getFinalValueAsAlias(String value, String asAlias) {
        return LinSQLCommons.applyAsAlias(value, asAlias, true, false);
    }

}

