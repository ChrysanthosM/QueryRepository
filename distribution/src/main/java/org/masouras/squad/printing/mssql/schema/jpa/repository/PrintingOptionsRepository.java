package org.masouras.squad.printing.mssql.schema.jpa.repository;

import org.masouras.squad.printing.mssql.schema.jpa.entity.PrintingOptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingOptionsRepository extends JpaRepository<PrintingOptionsEntity, Long> {}
