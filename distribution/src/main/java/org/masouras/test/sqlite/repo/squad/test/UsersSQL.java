package org.masouras.test.sqlite.repo.squad.test;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.loader.AbstractSQL;
import org.masouras.test.sqlite.schema.table.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("sqlite")
public class UsersSQL extends AbstractSQL<UsersRepo.NameOfSQL, UsersJ2SQL, UsersTable> {
    @Autowired
    public UsersSQL(UsersJ2SQL j2sql) {
        super(j2sql);
    }
}

