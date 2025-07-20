package org.masouras.db2i.schema.table;

import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.db2i.schema.structure.DbFieldDb2i;
import org.masouras.db2i.schema.structure.DbTableDb2i;
import org.springframework.stereotype.Component;

@Component
public final class AutoNumberingTable extends AbstractTable {
    private AutoNumberingTable() {
        super(DbTableDb2i.AUTO_NUMBERING);
        setDbFs(REC_ID, ENTITY_TYPE, ENTITY_NUMBER);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbFieldDb2i.REC_ID);
    public final PairOfTableField ENTITY_TYPE = getPairOfTableField(DbFieldDb2i.ENTITY_TYPE);
    public final PairOfTableField ENTITY_NUMBER = getPairOfTableField(DbFieldDb2i.ENTITY_NUMBER);
}
