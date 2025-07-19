package org.masouras.sqlite.repo.squad.test;

import org.masouras.base.repo.RepoBase;

public interface UsersRepo extends RepoBase {
    enum NameOfSQL {
        LIST,
        INSERT,
    }
}
