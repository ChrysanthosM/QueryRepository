package org.masouras.squad.printing.mssql.schema.jpa.repository;

import org.masouras.squad.printing.mssql.schema.jpa.entity.PrintingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingDataRepository extends JpaRepository<PrintingDataEntity, Long> {}
