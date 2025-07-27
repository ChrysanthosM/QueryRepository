package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.loader.AbstractSQL;
import org.masouras.test.mssql.schema.table.AutoNumberingTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("mssql")
public class AutoNumberingSQL extends AbstractSQL<AutoNumberingRepo.NameOfSQL, AutoNumberingJ2SQL, AutoNumberingTable> {
    @Autowired
    public AutoNumberingSQL(AutoNumberingJ2SQL j2sql) {
        super(j2sql);
    }
}

