package org.masouras.squad.printing.mssql.schema.jpa.repository;

import org.masouras.squad.printing.mssql.schema.jpa.entity.PrintingSetUpEntity;
import org.masouras.squad.printing.mssql.schema.jpa.entity.PrintingSetUpKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingSetUpRepository extends JpaRepository<PrintingSetUpEntity, PrintingSetUpKey> {}
