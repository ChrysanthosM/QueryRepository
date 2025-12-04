package org.masouras.printing.mssql.schema.qb.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.printing.mssql.schema.qb.structure.DbField;
import org.masouras.printing.mssql.schema.qb.structure.DbTable;


@J2SqlTable("mssql")
public class PrintingDataTable extends AbstractTable {
    private PrintingDataTable() {
        super(DbTable.PRINTING_DATA);
        setDbFs(REC_ID, PROCESSED, CURRENT_TIMESTAMP, ACTIVITY_ID, CONTENT_TYPE, CONTENT_BASE64);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField PROCESSED = getPairOfTableField(DbField.PROCESSED);
    public final PairOfTableField CURRENT_TIMESTAMP = getPairOfTableField(DbField.CURRENT_TIMESTAMP);
    public final PairOfTableField ACTIVITY_ID = getPairOfTableField(DbField.ACTIVITY_ID);
    public final PairOfTableField CONTENT_TYPE = getPairOfTableField(DbField.CONTENT_TYPE);
    public final PairOfTableField CONTENT_BASE64 = getPairOfTableField(DbField.CONTENT_BASE64);
}
