package org.masouras.mssql.repo.squad.test;

import org.masouras.base.repo.GenericSQL;
import org.masouras.mssql.schema.table.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class UsersSQL extends GenericSQL<UsersRepo.NameOfSQL, UsersJ2SQL, UsersTable> {
    @Autowired
    public UsersSQL(UsersJ2SQL j2sql) {
        super(j2sql);
    }
}

