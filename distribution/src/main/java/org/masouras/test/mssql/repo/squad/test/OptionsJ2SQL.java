package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.repo.loader.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.test.mssql.schema.table.OptionsTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlLoader("mssql")
public class OptionsJ2SQL extends AbstractJ2<OptionsRepo.NameOfSQL> implements OptionsRepo {
    private final OptionsTable optionsTable;
    @Autowired
    private OptionsJ2SQL(OptionsTable optionsTable) {
        super(NameOfSQL.class);
        this.optionsTable = optionsTable;
    }

    @LoadJ2SQL
    public void loadList() {
        addLoader(NameOfSQL.LIST, J2SQL.create(getDataSourceType()).from(optionsTable));
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(optionsTable).insertRow());
    }

    @LoadJ2SQL
    public void loadFind() {
        addLoader(NameOfSQL.FIND, J2SQL.create(getDataSourceType()).from(optionsTable).where(optionsTable.OPTION_TYPE.eq("?")));
    }
}
