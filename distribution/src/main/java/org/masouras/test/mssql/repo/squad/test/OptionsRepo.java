package org.masouras.test.mssql.repo.squad.test;

import org.masouras.base.repo.RepoBaseMSSQL;

public interface OptionsRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
