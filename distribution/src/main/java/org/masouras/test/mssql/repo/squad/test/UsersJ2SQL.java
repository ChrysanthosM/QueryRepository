package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.repo.loader.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.test.mssql.schema.table.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlLoader
public class UsersJ2SQL extends AbstractJ2<UsersRepo.NameOfSQL> implements UsersRepo {
    private final UsersTable usersTable;
    @Autowired
    private UsersJ2SQL(UsersTable usersTable) {
        super(NameOfSQL.class);
        this.usersTable = usersTable;
    }

    @LoadJ2SQL
    public void loadList() {
        addLoader(NameOfSQL.LIST, J2SQL.create(getDataSourceType()).from(usersTable));
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(usersTable).insertRow());
    }
}
