package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.squad.printing.mssql.schema.qb.table.PrintingDataTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("mssql")
public class PrintingDataSQL extends AbstractSQL<PrintingDataRepo.NameOfSQL, PrintingDataJ2SQL, PrintingDataTable> {
    @Autowired
    public PrintingDataSQL(PrintingDataJ2SQL j2sql) {
        super(j2sql);
    }
}

