package org.masouras.db2i.schema.table;

import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.db2i.schema.structure.DbFieldDb2i;
import org.masouras.db2i.schema.structure.DbTableDb2i;
import org.springframework.stereotype.Component;

@Component
public final class OptionsTable extends AbstractTable {
    public OptionsTable() {
        super(DbTableDb2i.OPTIONS);
        setDbFs(REC_ID, OPTION_TYPE, OPTION_NAME, OPTION_VALUE, OPTION_DETAILS);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbFieldDb2i.REC_ID);
    public final PairOfTableField OPTION_TYPE = getPairOfTableField(DbFieldDb2i.OPTION_TYPE);
    public final PairOfTableField OPTION_NAME = getPairOfTableField(DbFieldDb2i.OPTION_NAME);
    public final PairOfTableField OPTION_VALUE = getPairOfTableField(DbFieldDb2i.OPTION_VALUE);
    public final PairOfTableField OPTION_DETAILS = getPairOfTableField(DbFieldDb2i.OPTION_DETAILS);
    public final PairOfTableField USER_STAMP = getPairOfTableField(DbFieldDb2i.USER_STAMP);
    public final PairOfTableField DATE_STAMP = getPairOfTableField(DbFieldDb2i.DATE_STAMP);
}
