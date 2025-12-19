package org.masouras.squad.printing.mssql.schema.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.control.*;

@Entity
@Table(name = "PrintingSetUpTable")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PrintingSetUpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NonNull
    @Convert(converter = ActivityTypeConverter.class)
    @Column(name = "ACTIVITY_TYPE", nullable = false, length = 5)
    private ActivityType activityType;

    @NonNull
    @Convert(converter = ContentTypeConverter.class)
    @Column(name = "CONTENT_TYPE", nullable = false, length = 5)
    private ContentType contentType;

    @Column(name = "SEQ_NO")
    private int seqNo;

    @NonNull
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private ContentType letterType;
}

