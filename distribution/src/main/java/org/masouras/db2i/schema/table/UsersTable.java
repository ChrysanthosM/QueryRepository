package org.masouras.db2i.schema.table;

import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.db2i.schema.structure.DbFieldDb2i;
import org.masouras.db2i.schema.structure.DbTableDb2i;
import org.springframework.stereotype.Component;

@Component
public final class UsersTable extends AbstractTable {
    public UsersTable() {
        super(DbTableDb2i.USERS);
        setDbFs(REC_ID, USER_NAME, USER_PASSWORD);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbFieldDb2i.REC_ID);
    public final PairOfTableField USER_NAME = getPairOfTableField(DbFieldDb2i.USER_NAME);
    public final PairOfTableField USER_PASSWORD = getPairOfTableField(DbFieldDb2i.USER_PASSWORD);
}
