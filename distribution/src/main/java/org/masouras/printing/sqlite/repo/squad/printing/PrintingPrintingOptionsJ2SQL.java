package org.masouras.printing.sqlite.repo.squad.printing;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.printing.sqlite.schema.qb.table.PrintingOptionsTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlLoader("sqlite")
public class PrintingPrintingOptionsJ2SQL extends AbstractJ2<PrintingOptionsRepo.NameOfSQL> implements PrintingOptionsRepo {
    private final PrintingOptionsTable printingOptionsTable;
    @Autowired
    private PrintingPrintingOptionsJ2SQL(PrintingOptionsTable printingOptionsTable) {
        super(NameOfSQL.class, DataSourceType.SQLITE);
        this.printingOptionsTable = printingOptionsTable;
    }

    @LoadJ2SQL
    public void loadList() {
        addLoader(NameOfSQL.LIST, J2SQL.create(getDataSourceType()).from(printingOptionsTable));
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(printingOptionsTable).insertRow());
    }

    @LoadJ2SQL
    public void loadFind() {
        addLoader(NameOfSQL.FIND, J2SQL.create(getDataSourceType()).from(printingOptionsTable).where(printingOptionsTable.OPTION_TYPE.eq("?")));
    }
}
