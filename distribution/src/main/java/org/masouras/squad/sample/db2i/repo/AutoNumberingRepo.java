package org.masouras.squad.sample.db2i.repo;

import org.masouras.base.repo.datasource.RepoBaseDB2i;

public interface AutoNumberingRepo extends RepoBaseDB2i {
    enum NameOfSQL {
        LIST,
        INSERT,
        DELETE_ALL,
        FIND,
        MAX_NUMBER_PER_ENTITY,
    }
}
