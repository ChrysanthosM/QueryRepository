package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.repo.GenericSQL;
import org.masouras.test.db2i.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionsSQL extends GenericSQL<OptionsRepo.NameOfSQL, OptionsJ2SQL, OptionsTable> {
    @Autowired
    public OptionsSQL(OptionsJ2SQL j2sql) {
        super(j2sql);
    }
}

