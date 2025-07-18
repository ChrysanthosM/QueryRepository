package org.masouras.core;

import lombok.Getter;
import lombok.NonNull;
import org.masouras.base.builder.BaseDbField;
import org.masouras.base.builder.BaseDbTable;


@Getter
public final class PairOfTableField implements DeployFiltersBase, DeployOrderingBase, ProvideDataTypeForSQLBase {
    public static PairOfTableField of(BaseDbTable dbt, BaseDbField dbf) { return new PairOfTableField(dbt, dbf); }

    private final BaseDbTable baseDbTable;
    private final BaseDbField baseDbField;
    private final DbField dbField;
    private PairOfTableField(BaseDbTable baseDbTable, BaseDbField baseDbField) {
        this.baseDbTable = baseDbTable;
        this.baseDbField = baseDbField;
        this.dbField = DbFieldInstances.getInstance(this.baseDbField);
    }

    public SQLFieldObject as(@NonNull String asAlias) { return new SQLFieldObject(this, asAlias, null); }

    @Override
    public Boolean getInQuotesRequirement() {
        return this.baseDbField.getFieldDataType().getInQuotesRequirement();
    }
}
