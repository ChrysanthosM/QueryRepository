package org.masouras.core;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.lang3.tuple.Pair;
import org.masouras.base.builder.BaseDbField;
import org.masouras.base.builder.BaseDbTable;

import java.util.List;

@Getter(AccessLevel.PROTECTED)
abstract sealed class DbTable implements DbTableBase permits AbstractTable {
    public static final BaseDbField ALL = BaseDbField.all();

    protected abstract BaseDbTable getBaseDbTable();
    protected abstract String getSystemName();
    protected abstract String getTablePrefixForFields();
    protected abstract List<BaseDbField> getHasKeys();
    protected abstract Boolean getAutoIncrease();
    protected abstract Boolean getPutAutoStamp();

    protected abstract List<PairOfTableField> getDbFs();

    private DbTableInfo dbTableInfo = null;

    @PostConstruct
    private void loadTableInfo() {
        dbTableInfo = new DbTableInfo(this);
    }

    public Pair<DbTable, String> as(@NonNull J2SQLShared.PFX asAlias) { return as(asAlias.name()); }
    public Pair<DbTable, String> as(@NonNull String asAlias) { return Pair.of(this, asAlias); }
}
