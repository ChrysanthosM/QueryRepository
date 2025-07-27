package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.loader.AbstractSQL;
import org.masouras.test.mssql.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService
public class OptionsSQL extends AbstractSQL<OptionsRepo.NameOfSQL, OptionsJ2SQL, OptionsTable> {
    @Autowired
    public OptionsSQL(OptionsJ2SQL j2sql) {
        super(j2sql);
    }
}

