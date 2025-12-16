package org.masouras.squad.printing.mssql.schema.jpa.repository;

import org.masouras.squad.printing.mssql.schema.jpa.entity.PrintingFilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingFilesRepository extends JpaRepository<PrintingFilesEntity, Long> {}
