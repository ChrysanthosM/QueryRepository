package org.masouras.squad.printing.mssql.schema.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.control.ActivityType;
import org.masouras.squad.printing.mssql.schema.jpa.control.ActivityTypeConverter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ActivityTable")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Convert(converter = ActivityTypeConverter.class)
    @Column(name = "ACTIVITY_TYPE", nullable = false, length = 5)
    private ActivityType activityType;

    @NonNull
    @Column(name = "PGM_STAMP", nullable = false)
    private String pgmStamp;

    @NonNull
    @Column(name = "USER_STAMP", nullable = false)
    private String userStamp;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSSS")
    @Column(name = "DATE_STAMP", nullable = false)
    private LocalDateTime dateStamp;
}

