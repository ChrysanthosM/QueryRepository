package org.masouras.squad.printing.mssql.schema.qb.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbField;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbTable;


@J2SqlTable("mssql")
public class PrintingFilesTable extends AbstractTable {
    private PrintingFilesTable() {
        super(DbTable.PRINTING_FILES);
        setDbFs(REC_ID, CONTENT_BASE64);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField CONTENT_BASE64 = getPairOfTableField(DbField.CONTENT_BASE64);
}
