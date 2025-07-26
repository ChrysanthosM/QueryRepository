package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.repo.RepoBaseDB2i;

public interface AutoNumberingRepo extends RepoBaseDB2i {
    enum NameOfSQL {
        LIST,
        INSERT,
        DELETE_ALL,
        FIND,
        MAX_NUMBER_PER_ENTITY,
    }
}
