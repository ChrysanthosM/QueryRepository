package org.masouras.squad.sample.mssql.repo;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.squad.sample.mssql.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("mssql")
public class OptionsSQL extends AbstractSQL<OptionsRepo.NameOfSQL, OptionsJ2SQL, OptionsTable> {
    @Autowired
    public OptionsSQL(OptionsJ2SQL j2sql) {
        super(j2sql);
    }
}

