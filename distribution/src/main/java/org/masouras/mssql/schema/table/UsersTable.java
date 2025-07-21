package org.masouras.mssql.schema.table;

import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.mssql.schema.structure.DbField;
import org.masouras.mssql.schema.structure.DbTable;
import org.springframework.stereotype.Component;

@Component
public class UsersTable extends AbstractTable {
    public UsersTable() {
        super(DbTable.USERS);
        setDbFs(REC_ID, USER_NAME, USER_PASSWORD);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField USER_NAME = getPairOfTableField(DbField.USER_NAME);
    public final PairOfTableField USER_PASSWORD = getPairOfTableField(DbField.USER_PASSWORD);
}
