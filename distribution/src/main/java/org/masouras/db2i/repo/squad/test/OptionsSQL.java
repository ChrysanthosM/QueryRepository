package org.masouras.db2i.repo.squad.test;

import org.masouras.base.repo.GenericSQL;
import org.masouras.db2i.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class OptionsSQL extends GenericSQL<OptionsRepo.NameOfSQL, OptionsJ2SQL, OptionsTable> {
    @Autowired
    public OptionsSQL(OptionsJ2SQL j2sql) {
        super(j2sql);
    }
}

