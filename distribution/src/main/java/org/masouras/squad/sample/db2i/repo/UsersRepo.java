package org.masouras.squad.sample.db2i.repo;

import org.masouras.base.repo.datasource.RepoBaseDB2i;

public interface UsersRepo extends RepoBaseDB2i {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
