package org.masouras.printing.mssql.repo;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface PrintingOptionsRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
