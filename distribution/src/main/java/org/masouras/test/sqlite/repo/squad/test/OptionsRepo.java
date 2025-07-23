package org.masouras.test.sqlite.repo.squad.test;

import org.masouras.base.repo.RepoBase;

public interface OptionsRepo extends RepoBase {
    enum NameOfSQL {
        LIST,
        FIND,
        INSERT,
    }
}
