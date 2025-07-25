package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.repo.AbstractJ2;
import org.masouras.base.repo.LoadJ2SQL;
import org.masouras.core.J2SQL;
import org.masouras.test.db2i.schema.table.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersJ2SQL extends AbstractJ2<UsersRepo.NameOfSQL> implements UsersRepo {
    private final UsersTable usersTable;
    @Autowired
    private UsersJ2SQL(UsersTable usersTable) {
        super(NameOfSQL.class);
        this.usersTable = usersTable;
    }

    @LoadJ2SQL
    @SuppressWarnings("unused")
    public void loadList() {
        addLoader(NameOfSQL.LIST, J2SQL.create(getDataSourceType()).from(usersTable));
    }

    @LoadJ2SQL @SuppressWarnings("unused")
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(usersTable).insertRow());
    }
}
