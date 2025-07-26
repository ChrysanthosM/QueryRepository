package org.masouras.test.sqlite.repo.squad.test;

import org.masouras.base.repo.RepoBaseSQLite;

public interface AutoNumberingRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        INSERT,
        DELETE_ALL,
        FIND,
        MAX_NUMBER_PER_ENTITY,
    }
}
