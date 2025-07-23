package org.masouras.test.mssql.schema.table;

import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.test.mssql.schema.structure.DbField;
import org.masouras.test.mssql.schema.structure.DbTable;
import org.springframework.stereotype.Component;

@Component
public class OptionsTable extends AbstractTable {
    public OptionsTable() {
        super(DbTable.OPTIONS);
        setDbFs(REC_ID, OPTION_TYPE, OPTION_NAME, OPTION_VALUE, OPTION_DETAILS);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField OPTION_TYPE = getPairOfTableField(DbField.OPTION_TYPE);
    public final PairOfTableField OPTION_NAME = getPairOfTableField(DbField.OPTION_NAME);
    public final PairOfTableField OPTION_VALUE = getPairOfTableField(DbField.OPTION_VALUE);
    public final PairOfTableField OPTION_DETAILS = getPairOfTableField(DbField.OPTION_DETAILS);
    public final PairOfTableField USER_STAMP = getPairOfTableField(DbField.USER_STAMP);
    public final PairOfTableField DATE_STAMP = getPairOfTableField(DbField.DATE_STAMP);
}
