package org.masouras.squad.sample.mssql.repo;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.squad.sample.mssql.schema.table.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlLoader("maria")
public class UsersJ2SQL extends AbstractJ2<UsersRepo.NameOfSQL> implements UsersRepo {
    private final UsersTable usersTable;
    @Autowired
    private UsersJ2SQL(UsersTable usersTable) {
        super(NameOfSQL.class, DataSourceType.MARIA);
        this.usersTable = usersTable;
    }

    @LoadJ2SQL
    public void loadList() {
        addLoader(NameOfSQL.LIST, newJ2SQL().from(usersTable));
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, newJ2SQL().insertInto(usersTable).insertRow());
    }
}
