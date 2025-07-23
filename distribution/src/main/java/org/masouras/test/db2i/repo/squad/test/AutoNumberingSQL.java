package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.repo.GenericSQL;
import org.masouras.test.db2i.schema.table.AutoNumberingTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoNumberingSQL extends GenericSQL<AutoNumberingRepo.NameOfSQL, AutoNumberingJ2SQL, AutoNumberingTable> {
    @Autowired
    public AutoNumberingSQL(AutoNumberingJ2SQL j2sql) {
        super(j2sql);
    }
}

