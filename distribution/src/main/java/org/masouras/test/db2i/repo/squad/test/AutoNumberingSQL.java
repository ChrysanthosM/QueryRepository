package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.loader.AbstractSQL;
import org.masouras.test.db2i.schema.table.AutoNumberingTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("db2i")
public class AutoNumberingSQL extends AbstractSQL<AutoNumberingRepo.NameOfSQL, AutoNumberingJ2SQL, AutoNumberingTable> {
    @Autowired
    public AutoNumberingSQL(AutoNumberingJ2SQL j2sql) {
        super(j2sql);
    }
}

