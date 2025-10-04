package org.masouras.sample.db2i.repo.squad.data;

import org.masouras.base.repo.datasource.RepoBaseDB2i;

public interface UsersRepo extends RepoBaseDB2i {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
