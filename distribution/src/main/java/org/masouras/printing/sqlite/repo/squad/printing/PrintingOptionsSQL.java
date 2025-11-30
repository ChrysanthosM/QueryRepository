package org.masouras.printing.sqlite.repo.squad.printing;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.printing.sqlite.schema.qb.table.PrintingOptionsTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("sqlite")
public class PrintingOptionsSQL extends AbstractSQL<PrintingOptionsRepo.NameOfSQL, PrintingPrintingOptionsJ2SQL, PrintingOptionsTable> {
    @Autowired
    public PrintingOptionsSQL(PrintingPrintingOptionsJ2SQL j2sql) {
        super(j2sql);
    }
}

