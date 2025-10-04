package org.masouras.sample.mssql.repo.squad.data;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface UsersRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
