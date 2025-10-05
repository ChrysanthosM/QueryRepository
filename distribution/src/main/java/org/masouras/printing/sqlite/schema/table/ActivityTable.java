package org.masouras.printing.sqlite.schema.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.printing.sqlite.schema.structure.DbField;
import org.masouras.printing.sqlite.schema.structure.DbTable;

@J2SqlTable("sqlite")
public class ActivityTable extends AbstractTable {
    private ActivityTable() {
        super(DbTable.ACTIVITIES);
        setDbFs(REC_ID, ACTIVITY_TYPE, USER_STAMP, DATE_STAMP, PGM_STAMP);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField ACTIVITY_TYPE = getPairOfTableField(DbField.ACTIVITY_TYPE);
    public final PairOfTableField USER_STAMP = getPairOfTableField(DbField.USER_STAMP);
    public final PairOfTableField DATE_STAMP = getPairOfTableField(DbField.DATE_STAMP);
    public final PairOfTableField PGM_STAMP = getPairOfTableField(DbField.PGM_STAMP);
}
