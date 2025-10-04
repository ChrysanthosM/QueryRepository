package org.masouras.printing.sqlite.repo.squad.data;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface OptionsRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
