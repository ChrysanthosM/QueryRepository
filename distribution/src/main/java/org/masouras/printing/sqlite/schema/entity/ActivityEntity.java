package org.masouras.printing.sqlite.schema.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ActivityTable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ACTIVITY_TYPE", nullable = false, length = 5)
    private String activityType;

    @Column(name = "PGM_STAMP")
    private String pgmStamp;

    @Column(name = "USER_STAMP")
    private String userStamp;

    @Column(name = "DATE_STAMP")
    private LocalDateTime dateStamp;
}

