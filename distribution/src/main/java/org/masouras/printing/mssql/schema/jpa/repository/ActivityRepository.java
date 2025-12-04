package org.masouras.printing.mssql.schema.jpa.repository;

import org.masouras.printing.mssql.schema.jpa.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {}
