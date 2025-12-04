package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.squad.printing.mssql.schema.qb.table.ActivityTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("mssql")
public class ActivitySQL extends AbstractSQL<ActivityRepo.NameOfSQL, ActivityJ2SQL, ActivityTable> {
    @Autowired
    public ActivitySQL(ActivityJ2SQL j2sql) {
        super(j2sql);
    }
}

