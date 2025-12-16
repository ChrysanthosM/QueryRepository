package org.masouras.squad.printing.mssql.schema.qb.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbTable;


@J2SqlTable("mssql")
public class PrintingDataTable extends AbstractTable {
    private PrintingDataTable() {
        super(DbTable.PRINTING_DATA);
        setDbFs(REC_ID, PRINTING_STATUS, MODIFIED_AT, ACTIVITY_ID, CONTENT_TYPE, EXTENSION_TYPE, ERROR_MESSAGE,
                INITIAL_CONTENT_ID, VALIDATED_CONTENT_ID, FINAL_CONTENT_ID);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField PRINTING_STATUS = getPairOfTableField(DbField.PRINTING_STATUS);
    public final PairOfTableField MODIFIED_AT = getPairOfTableField(DbField.MODIFIED_AT);
    public final PairOfTableField ACTIVITY_ID = getPairOfTableField(DbField.ACTIVITY_ID);
    public final PairOfTableField CONTENT_TYPE = getPairOfTableField(DbField.CONTENT_TYPE);
    public final PairOfTableField EXTENSION_TYPE = getPairOfTableField(DbField.EXTENSION_TYPE);
    public final PairOfTableField ERROR_MESSAGE = getPairOfTableField(DbField.ERROR_MESSAGE);
    public final PairOfTableField INITIAL_CONTENT_ID = getPairOfTableField(DbField.INITIAL_CONTENT_ID);
    public final PairOfTableField VALIDATED_CONTENT_ID = getPairOfTableField(DbField.VALIDATED_CONTENT_ID);
    public final PairOfTableField FINAL_CONTENT_ID = getPairOfTableField(DbField.FINAL_CONTENT_ID);
}
