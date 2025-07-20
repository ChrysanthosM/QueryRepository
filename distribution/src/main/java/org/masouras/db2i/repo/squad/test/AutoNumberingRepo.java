package org.masouras.db2i.repo.squad.test;

import org.masouras.base.repo.RepoBase;

public interface AutoNumberingRepo extends RepoBase {
    enum NameOfSQL {
        LIST,
        INSERT,
        DELETE_ALL,
        FIND,
        MAX_NUMBER_PER_ENTITY,
    }
}
