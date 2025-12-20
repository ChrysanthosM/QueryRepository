package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.squad.printing.mssql.schema.jpa.control.PrintingStatus;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbField;
import org.masouras.squad.printing.mssql.schema.qb.table.PrintingDataTable;
import org.masouras.squad.printing.mssql.schema.qb.table.PrintingFilesTable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.masouras.core.J2SQLShared.PFX;

@J2SqlLoader("mssql")
public class PrintingDataJ2SQL extends AbstractJ2<PrintingDataRepo.NameOfSQL> implements PrintingDataRepo {
    private final PrintingDataTable printingDataTable;
    private final PrintingFilesTable printingFilesTable;
    @Autowired
    private PrintingDataJ2SQL(PrintingDataTable printingDataTable, PrintingFilesTable printingFilesTable) {
        super(NameOfSQL.class, DataSourceType.MSSQL);
        this.printingDataTable = printingDataTable;
        this.printingFilesTable = printingFilesTable;
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(printingDataTable).insertRow());
    }

    @LoadJ2SQL
    public void loadListUnprocessed() {
        addLoader(NameOfSQL.LIST_UNPROCESSED, J2SQL.create(getDataSourceType()).from(printingDataTable.as(PFX.T0)).selectAll()
                .fullJoin(printingFilesTable.as(PFX.T1)).on(PFX.t0(printingDataTable.INITIAL_CONTENT_ID).eq(PFX.t1(printingFilesTable.REC_ID))).fromJoinSelectOnly(printingFilesTable.CONTENT_BASE64.as(DbField.INITIAL_CONTENT_BASE64.systemName()))
                .where(printingDataTable.PRINTING_STATUS.eq(PrintingStatus.INSERTED.getCode()))
                .orderBy(printingDataTable.REC_ID));
    }

    @LoadJ2SQL
    public void loadUpdateSetProcessed() {
        addLoader(NameOfSQL.UPDATE_SET_PROCESSED, J2SQL.create(getDataSourceType()).updateInto(printingDataTable)
                .updateFieldSetValue(printingDataTable.PRINTING_STATUS, PrintingStatus.PROCESSED.getCode())
                .where(printingDataTable.REC_ID.eq("?")));
    }

}
