package org.masouras.squad.sample.sqlite.schema.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.squad.sample.sqlite.schema.structure.DbField;
import org.masouras.squad.sample.sqlite.schema.structure.DbTable;

@J2SqlTable("sqlite")
public class AutoNumberingTable extends AbstractTable {
    private AutoNumberingTable() {
        super(DbTable.AUTO_NUMBERING);
        setDbFs(REC_ID, ENTITY_TYPE, ENTITY_NUMBER);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField ENTITY_TYPE = getPairOfTableField(DbField.ENTITY_TYPE);
    public final PairOfTableField ENTITY_NUMBER = getPairOfTableField(DbField.ENTITY_NUMBER);
}
