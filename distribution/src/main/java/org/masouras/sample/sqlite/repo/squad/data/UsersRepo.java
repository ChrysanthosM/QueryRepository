package org.masouras.sample.sqlite.repo.squad.data;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface UsersRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
