package org.masouras.printing.mssql.repo;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface PrintingDataRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        INSERT,
        LIST_UNPROCESSED,
        UPDATE_SET_PROCESSED,
    }
}
