package org.masouras.printing.sqlite.schema.repository;

import org.masouras.printing.sqlite.schema.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {}
