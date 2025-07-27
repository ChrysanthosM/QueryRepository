package org.masouras.test.db2i.repo.squad.test;

import org.masouras.base.repo.datasource.RepoBaseDB2i;

public interface OptionsRepo extends RepoBaseDB2i {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
