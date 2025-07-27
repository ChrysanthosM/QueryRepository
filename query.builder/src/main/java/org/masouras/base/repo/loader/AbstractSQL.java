package org.masouras.base.repo.loader;

import org.masouras.core.J2SQL;

public abstract class AbstractSQL<R extends Enum<R>, J extends AbstractJ2<R>, T> {
    protected final J j2sql;
    protected AbstractSQL(J j2sql) {
        this.j2sql = j2sql;
    }

    public String getSQL(R nameOfSQL) {
        return j2sql.getSQL(nameOfSQL);
    }

    public J2SQL getJ2SQL(R nameOfSQL) {
        return j2sql.getJ2SQL(nameOfSQL);
    }

//    public Query getQuery(R nameOfSQL, Class<T> tableClass) {
//        return j2sql.getQuery(nameOfSQL, tableClass);
//    }
}


