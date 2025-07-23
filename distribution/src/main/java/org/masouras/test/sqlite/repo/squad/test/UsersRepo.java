package org.masouras.test.sqlite.repo.squad.test;

import org.masouras.base.repo.RepoBase;

public interface UsersRepo extends RepoBase {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
