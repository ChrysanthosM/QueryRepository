package org.masouras.test.sqlite.repo.squad.test;

import org.masouras.base.repo.datasource.RepoBaseSQLite;

public interface UsersRepo extends RepoBaseSQLite {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
