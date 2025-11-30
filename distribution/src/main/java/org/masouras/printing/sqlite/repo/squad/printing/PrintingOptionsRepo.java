package org.masouras.printing.sqlite.repo.squad.printing;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface PrintingOptionsRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
