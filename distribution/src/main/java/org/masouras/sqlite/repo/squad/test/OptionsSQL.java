package org.masouras.sqlite.repo.squad.test;

import org.masouras.base.repo.GenericSQL;
import org.masouras.sqlite.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class OptionsSQL extends GenericSQL<OptionsRepo.NameOfSQL, OptionsJ2SQL, OptionsTable> {
    @Autowired
    public OptionsSQL(OptionsJ2SQL j2sql) {
        super(j2sql);
    }
}

