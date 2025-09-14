package org.masouras.sample.sqlite.repo.squad.test;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.sample.sqlite.schema.table.AutoNumberingTable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.masouras.core.J2SQLShared.MAX;

@J2SqlLoader("sqlite")
public class AutoNumberingJ2SQL extends AbstractJ2<AutoNumberingRepo.NameOfSQL> implements AutoNumberingRepo {
    private final AutoNumberingTable autoNumberingTable;
    @Autowired
    private AutoNumberingJ2SQL(AutoNumberingTable autoNumberingTable) {
        super(NameOfSQL.class, DataSourceType.SQLITE);
        this.autoNumberingTable = autoNumberingTable;
    }

    @LoadJ2SQL
    public void loadList() {
        addLoader(NameOfSQL.LIST, J2SQL.create(getDataSourceType()).from(autoNumberingTable));
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(autoNumberingTable).insertRow());
    }

    @LoadJ2SQL
    public void loadFind() {
        addLoader(NameOfSQL.FIND, J2SQL.create(getDataSourceType()).from(autoNumberingTable).where(autoNumberingTable.ENTITY_TYPE.eq("?")));
    }

    @LoadJ2SQL
    public void loadMaxNumberPerEntity() {
        addLoader(NameOfSQL.MAX_NUMBER_PER_ENTITY, J2SQL.create(getDataSourceType()).from(autoNumberingTable)
                .select(autoNumberingTable.ENTITY_TYPE, MAX(autoNumberingTable.ENTITY_NUMBER))
                .groupBy(autoNumberingTable.ENTITY_TYPE)
                .orderBy(autoNumberingTable.ENTITY_TYPE));
    }

    @LoadJ2SQL
    public void loadDeleteAll() {
        addLoader(NameOfSQL.DELETE_ALL, J2SQL.create(getDataSourceType()).deleteFrom(autoNumberingTable));
    }

}
