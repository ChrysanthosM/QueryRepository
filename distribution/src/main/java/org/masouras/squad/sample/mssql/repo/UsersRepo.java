package org.masouras.squad.sample.mssql.repo;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface UsersRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
