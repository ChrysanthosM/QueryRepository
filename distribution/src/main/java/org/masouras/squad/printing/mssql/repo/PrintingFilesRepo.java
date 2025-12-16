package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface PrintingFilesRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        INSERT,
        FIND_BY_ID,
    }
}
