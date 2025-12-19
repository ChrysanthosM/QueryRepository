package org.masouras.squad.printing.mssql.schema.qb.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbTable;

@J2SqlTable("mssql")
public class LetterSetUpTable extends AbstractTable {
    public LetterSetUpTable() {
        super(DbTable.LETTER_SETUP);
        setDbFs(REC_ID, LETTER_TYPE, SEQ_NO, LETTER_TYPE, XSL_TYPE, VALID_FLAG);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField LETTER_TYPE = getPairOfTableField(DbField.LETTER_TYPE);
    public final PairOfTableField SEQ_NO = getPairOfTableField(DbField.SEQ_NO);
    public final PairOfTableField XSL_TYPE = getPairOfTableField(DbField.XSL_TYPE);
    public final PairOfTableField VALID_FLAG = getPairOfTableField(DbField.VALID_FLAG);
}
