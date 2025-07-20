package org.masouras.mssql.repo.squad.test;

import org.masouras.base.repo.RepoBase;

public interface UsersRepo extends RepoBase {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
