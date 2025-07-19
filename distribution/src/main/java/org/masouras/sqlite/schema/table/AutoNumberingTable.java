package org.masouras.sqlite.schema.table;

import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.sqlite.schema.structure.DbFieldSQLite;
import org.masouras.sqlite.schema.structure.DbTableSQLite;
import org.springframework.stereotype.Component;

@Component
public final class AutoNumberingTable extends AbstractTable {
    private AutoNumberingTable() {
        super(DbTableSQLite.AUTO_NUMBERING);
        setDbFs(REC_ID, ENTITY_TYPE, ENTITY_NUMBER);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbFieldSQLite.REC_ID);
    public final PairOfTableField ENTITY_TYPE = getPairOfTableField(DbFieldSQLite.ENTITY_TYPE);
    public final PairOfTableField ENTITY_NUMBER = getPairOfTableField(DbFieldSQLite.ENTITY_NUMBER);
}
