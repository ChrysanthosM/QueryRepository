package org.masouras.sample.mssql.repo.squad.test;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface AutoNumberingRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST,
        INSERT,
        DELETE_ALL,
        FIND,
        MAX_NUMBER_PER_ENTITY,
    }
}
