package org.masouras.squad.printing.mssql.repo;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface PrintingDataRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        INSERT,
        LIST_UNPROCESSED,
        UPDATE_SET_PROCESSED,
    }
}
