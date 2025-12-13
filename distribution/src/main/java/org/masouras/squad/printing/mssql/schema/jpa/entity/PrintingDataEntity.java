package org.masouras.squad.printing.mssql.schema.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.masouras.squad.printing.mssql.schema.jpa.control.ContentType;
import org.masouras.squad.printing.mssql.schema.jpa.control.ContentTypeConverter;
import org.masouras.squad.printing.mssql.schema.jpa.control.FileExtensionType;
import org.masouras.squad.printing.mssql.schema.jpa.control.FileExtensionTypeConverter;

import java.time.LocalDateTime;

@Entity
@Table(name = "PrintingDataTable")
@Data
@EqualsAndHashCode(exclude = "activity")
@NoArgsConstructor
@RequiredArgsConstructor
public class PrintingDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @Column(name = "PROCESSED")
    private boolean processed;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSSS")
    @UpdateTimestamp
    @Column(name = "MODIFIED_AT", nullable = false)
    private LocalDateTime modifiedAt;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACTIVITY_ID", nullable = false)
    private ActivityEntity activity;

    @NonNull
    @Convert(converter = ContentTypeConverter.class)
    @Column(name = "CONTENT_TYPE", nullable = false, length = 5)
    private ContentType contentType;

    @NonNull
    @Convert(converter = FileExtensionTypeConverter.class)
    @Column(name = "EXTENSION_TYPE", nullable = false, length = 5)
    private FileExtensionType fileExtensionType;


    @Column(name = "CONTENT_VALIDATED")
    private boolean contentValidated;

    @NonNull
    @Lob
    @Column(name = "CONTENT_BASE64", nullable = false)
    private String contentBase64;


    @PrePersist
    protected void onCreate() {
        this.processed = false;
        this.contentValidated = false;
        this.modifiedAt = LocalDateTime.now();
    }
}
