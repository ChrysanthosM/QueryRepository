package org.masouras.printing.sqlite.schema.repository;

import org.masouras.printing.sqlite.schema.entity.PrintingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingDataRepository extends JpaRepository<PrintingDataEntity, Long> {}
