package org.masouras.squad.sample.sqlite.repo;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface AutoNumberingRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        INSERT,
        DELETE_ALL,
        FIND,
        MAX_NUMBER_PER_ENTITY,
    }
}
