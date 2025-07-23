package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.repo.GenericSQL;
import org.masouras.test.db2i.schema.table.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersSQL extends GenericSQL<UsersRepo.NameOfSQL, UsersJ2SQL, UsersTable> {
    @Autowired
    public UsersSQL(UsersJ2SQL j2sql) {
        super(j2sql);
    }
}

