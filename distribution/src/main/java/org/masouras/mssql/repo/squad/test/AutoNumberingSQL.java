package org.masouras.mssql.repo.squad.test;

import org.masouras.base.repo.GenericSQL;
import org.masouras.mssql.schema.table.AutoNumberingTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class AutoNumberingSQL extends GenericSQL<AutoNumberingRepo.NameOfSQL, AutoNumberingJ2SQL, AutoNumberingTable> {
    @Autowired
    public AutoNumberingSQL(AutoNumberingJ2SQL j2sql) {
        super(j2sql);
    }
}

