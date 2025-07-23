package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.repo.AbstractJ2;
import org.masouras.base.repo.LoadJ2SQL;
import org.masouras.core.J2SQL;
import org.masouras.test.mssql.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionsJ2SQL extends AbstractJ2<OptionsRepo.NameOfSQL> implements OptionsRepo {
    private final OptionsTable optionsTable;
    @Autowired
    private OptionsJ2SQL(OptionsTable optionsTable) {
        super(NameOfSQL.class);
        this.optionsTable = optionsTable;
    }

    @LoadJ2SQL
    @SuppressWarnings("unused")
    public void loadList() {
        addLoader(NameOfSQL.LIST, J2SQL.create(getWorkWithDataSource()).from(optionsTable));
    }

    @LoadJ2SQL @SuppressWarnings("unused")
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getWorkWithDataSource()).insertInto(optionsTable).insertRow());
    }

    @LoadJ2SQL @SuppressWarnings("unused")
    public void loadFind() {
        addLoader(NameOfSQL.FIND, J2SQL.create(getWorkWithDataSource()).from(optionsTable).where(optionsTable.OPTION_TYPE.eq("?")));
    }
}
