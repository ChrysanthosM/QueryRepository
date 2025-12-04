package org.masouras.squad.sample.mssql.repo;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface OptionsRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
