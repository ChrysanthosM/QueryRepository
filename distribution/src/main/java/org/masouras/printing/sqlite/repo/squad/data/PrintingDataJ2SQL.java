package org.masouras.printing.sqlite.repo.squad.data;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.printing.sqlite.schema.table.PrintingDataTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlLoader("sqlite")
public class PrintingDataJ2SQL extends AbstractJ2<PrintingDataRepo.NameOfSQL> implements PrintingDataRepo {
    private final PrintingDataTable printingDataTable;
    @Autowired
    private PrintingDataJ2SQL(PrintingDataTable printingDataTable) {
        super(NameOfSQL.class, DataSourceType.SQLITE);
        this.printingDataTable = printingDataTable;
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(printingDataTable).insertRow());
    }


}
