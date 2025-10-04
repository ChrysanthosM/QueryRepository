package org.masouras.printing.sqlite.repo.squad.data;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.printing.sqlite.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("sqlite")
public class OptionsSQL extends AbstractSQL<OptionsRepo.NameOfSQL, OptionsJ2SQL, OptionsTable> {
    @Autowired
    public OptionsSQL(OptionsJ2SQL j2sql) {
        super(j2sql);
    }
}

