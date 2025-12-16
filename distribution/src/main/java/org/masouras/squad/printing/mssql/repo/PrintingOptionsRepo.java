package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface PrintingOptionsRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
