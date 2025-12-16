package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.squad.printing.mssql.schema.qb.table.PrintingFilesTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlLoader("mssql")
public class PrintingFilesJ2SQL extends AbstractJ2<PrintingFilesRepo.NameOfSQL> implements PrintingFilesRepo {
    private final PrintingFilesTable printingFilesTable;
    @Autowired
    private PrintingFilesJ2SQL(PrintingFilesTable printingFilesTable) {
        super(NameOfSQL.class, DataSourceType.MSSQL);
        this.printingFilesTable = printingFilesTable;
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(printingFilesTable).insertRow());
    }

    @LoadJ2SQL
    public void loadFindById() {
        addLoader(NameOfSQL.FIND_BY_ID, J2SQL.create(getDataSourceType()).from(printingFilesTable)
                .where(printingFilesTable.REC_ID.eq("?")));
    }

}
