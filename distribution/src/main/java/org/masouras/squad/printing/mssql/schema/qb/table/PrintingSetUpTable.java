package org.masouras.squad.printing.mssql.schema.qb.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbTable;

@J2SqlTable("mssql")
public class PrintingSetUpTable extends AbstractTable {
    public PrintingSetUpTable() {
        super(DbTable.PRINTING_SETUP);
        setDbFs(REC_ID, ACTIVITY_TYPE, CONTENT_TYPE, SEQ_NO, LETTER_TYPE);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField ACTIVITY_TYPE = getPairOfTableField(DbField.ACTIVITY_TYPE);
    public final PairOfTableField CONTENT_TYPE = getPairOfTableField(DbField.CONTENT_TYPE);
    public final PairOfTableField SEQ_NO = getPairOfTableField(DbField.SEQ_NO);
    public final PairOfTableField LETTER_TYPE = getPairOfTableField(DbField.LETTER_TYPE);
}
