package org.masouras.sample.db2i.schema.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.sample.db2i.schema.structure.DbField;
import org.masouras.sample.db2i.schema.structure.DbTable;

@J2SqlTable("db2i")
public class UsersTable extends AbstractTable {
    public UsersTable() {
        super(DbTable.USERS);
        setDbFs(REC_ID, USER_NAME, USER_PASSWORD);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField USER_NAME = getPairOfTableField(DbField.USER_NAME);
    public final PairOfTableField USER_PASSWORD = getPairOfTableField(DbField.USER_PASSWORD);
}
