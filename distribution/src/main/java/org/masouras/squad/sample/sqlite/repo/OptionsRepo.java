package org.masouras.squad.sample.sqlite.repo;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface OptionsRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
