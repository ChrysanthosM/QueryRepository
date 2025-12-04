package org.masouras.squad.sample.db2i.repo;

import org.masouras.base.repo.datasource.RepoBaseDB2i;

public interface OptionsRepo extends RepoBaseDB2i {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
