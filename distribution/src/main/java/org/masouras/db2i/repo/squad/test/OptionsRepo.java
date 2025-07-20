package org.masouras.db2i.repo.squad.test;

import org.masouras.base.repo.RepoBase;

public interface OptionsRepo extends RepoBase {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
