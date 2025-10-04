package org.masouras.sample.mssql.repo.squad.data;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface OptionsRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
