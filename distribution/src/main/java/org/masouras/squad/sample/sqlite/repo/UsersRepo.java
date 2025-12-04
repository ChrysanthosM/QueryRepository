package org.masouras.squad.sample.sqlite.repo;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface UsersRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
