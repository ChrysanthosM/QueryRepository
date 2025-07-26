package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.repo.RepoBaseMSSQL;

public interface UsersRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
