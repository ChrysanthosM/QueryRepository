package org.masouras.sample.sqlite.repo.squad.data;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.sample.sqlite.schema.table.AutoNumberingTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("sqlite")
public class AutoNumberingSQL extends AbstractSQL<AutoNumberingRepo.NameOfSQL, AutoNumberingJ2SQL, AutoNumberingTable> {
    @Autowired
    public AutoNumberingSQL(AutoNumberingJ2SQL j2sql) {
        super(j2sql);
    }
}

