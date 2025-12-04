package org.masouras.printing.mssql.repo;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.core.J2SQL;
import org.masouras.printing.mssql.schema.qb.table.ActivityTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlLoader("mssql")
public class ActivityJ2SQL extends AbstractJ2<ActivityRepo.NameOfSQL> implements ActivityRepo {
    private final ActivityTable activityTable;
    @Autowired
    private ActivityJ2SQL(ActivityTable activityTable) {
        super(NameOfSQL.class, DataSourceType.MSSQL);
        this.activityTable = activityTable;
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, J2SQL.create(getDataSourceType()).insertInto(activityTable).insertRow());
    }


}
