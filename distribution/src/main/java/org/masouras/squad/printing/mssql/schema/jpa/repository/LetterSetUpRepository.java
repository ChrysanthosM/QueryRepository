package org.masouras.squad.printing.mssql.schema.jpa.repository;

import org.masouras.squad.printing.mssql.schema.jpa.entity.LetterSetUpEntity;
import org.masouras.squad.printing.mssql.schema.jpa.entity.LetterSetUpKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterSetUpRepository extends JpaRepository<LetterSetUpEntity, LetterSetUpKey> {}
