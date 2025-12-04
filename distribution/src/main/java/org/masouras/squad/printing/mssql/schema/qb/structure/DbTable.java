package org.masouras.squad.printing.mssql.schema.qb.structure;

import org.masouras.base.builder.BaseDbField;
import org.masouras.base.builder.BaseDbTable;
import org.masouras.base.builder.ConfigDbTable;

import java.util.List;

public enum DbTable implements BaseDbTable {
    PRINTING_DATA("PrintingDataTable", null, List.of(DbField.REC_ID), true, true),
    PRINTING_OPTIONS("PrintingOptionsTable", null, List.of(DbField.REC_ID), true, false),
    ACTIVITIES("ActivityTable", null, List.of(DbField.REC_ID), true, false),
    ;

    private final ConfigDbTable configDbTable;
    DbTable(String systemName, String tablePrefixForFields, List<BaseDbField> hasKeys, Boolean autoIncrease, Boolean putAutoStamp) {
        this.configDbTable = new ConfigDbTable(systemName, tablePrefixForFields, hasKeys, autoIncrease, putAutoStamp);
    }
    @Override
    public String systemName() { return this.configDbTable.systemName(); }
    @Override
    public String tablePrefix() { return this.configDbTable.tablePrefixForFields(); }
    @Override
    public List<BaseDbField> keys() { return this.configDbTable.hasKeys(); }
    @Override
    public Boolean autoIncrease() { return this.configDbTable.autoIncrease(); }
    @Override
    public Boolean putAutoStamp() { return this.configDbTable.putAutoStamp(); }

    @Override
    public BaseDbField getUserStampDbF() { return DbField.USER_STAMP; }
    @Override
    public BaseDbField getDateStampDbF() { return DbField.DATE_STAMP; }
}
