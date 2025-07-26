package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.repo.RepoBaseDB2i;

public interface OptionsRepo extends RepoBaseDB2i {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
