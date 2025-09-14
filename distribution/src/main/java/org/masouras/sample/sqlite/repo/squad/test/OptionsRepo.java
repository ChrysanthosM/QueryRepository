package org.masouras.sample.sqlite.repo.squad.test;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface OptionsRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
