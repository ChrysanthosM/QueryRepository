package org.masouras.sample.db2i.repo.squad.test;

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
