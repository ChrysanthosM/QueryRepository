package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.squad.printing.mssql.schema.jpa.control.ValidFlag;
import org.masouras.squad.printing.mssql.schema.qb.table.LetterSetUpTable;
import org.masouras.squad.printing.mssql.schema.qb.table.PrintingSetUpTable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.masouras.core.J2SQLShared.PFX.*;

@J2SqlLoader("mssql")
public class PrintingOptionsJ2SQL extends AbstractJ2<PrintingOptionsRepo.NameOfSQL> implements PrintingOptionsRepo {
    private final PrintingSetUpTable printingSetUpTable;
    private final LetterSetUpTable letterSetUpTable;
    @Autowired
    private PrintingOptionsJ2SQL(PrintingSetUpTable printingSetUpTable, LetterSetUpTable letterSetUpTable) {
        super(NameOfSQL.class, DataSourceType.MSSQL);
        this.printingSetUpTable = printingSetUpTable;
        this.letterSetUpTable = letterSetUpTable;
    }

    @LoadJ2SQL
    public void loadListPrintingSetUp() {
        addLoader(NameOfSQL.LIST_PRINTING_SETUP, J2SQL.create(getDataSourceType())
                .from(printingSetUpTable.as(T0)).select(t0(printingSetUpTable.ACTIVITY_TYPE, printingSetUpTable.CONTENT_TYPE, printingSetUpTable.LETTER_TYPE))
                .fullJoin(letterSetUpTable.as(J1)).on(t0(printingSetUpTable.LETTER_TYPE).eq(j1(letterSetUpTable.LETTER_TYPE))).fromJoinSelectOnly(j1(letterSetUpTable.XSL_TYPE, letterSetUpTable.RENDER_TYPE, letterSetUpTable.VALID_FLAG))
                .where(j1(letterSetUpTable.VALID_FLAG).ne(ValidFlag.DISABLED))
                .orderBy(t0(printingSetUpTable.SEQ_NO), j1(letterSetUpTable.SEQ_NO))
        );
    }

}
