package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.test.mssql.schema.table.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("mssql")
public class UsersSQL extends AbstractSQL<UsersRepo.NameOfSQL, UsersJ2SQL, UsersTable> {
    @Autowired
    public UsersSQL(UsersJ2SQL j2sql) {
        super(j2sql);
    }
}

