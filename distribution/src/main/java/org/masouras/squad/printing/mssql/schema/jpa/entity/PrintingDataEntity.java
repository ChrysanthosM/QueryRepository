package org.masouras.squad.printing.mssql.schema.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.masouras.squad.printing.mssql.schema.jpa.control.*;

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

    @Column(name = "PRINTING_STATUS", nullable = false, length = 1)
    @Convert(converter = PrintingStatusConverter.class)
    private PrintingStatus printingStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSSS")
    @UpdateTimestamp
    @Column(name = "MODIFIED_AT", nullable = false)
    private LocalDateTime modifiedAt;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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


    @Column(name = "ERROR_MESSAGE", length = 1024)
    private String errorMessage;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INITIAL_CONTENT_ID", nullable = false)
    private PrintingFilesEntity initialContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VALIDATED_CONTENT_ID")
    private PrintingFilesEntity validatedContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FINAL_CONTENT_ID")
    private PrintingFilesEntity finalContent;


    @PrePersist
    protected void onCreate() {
        this.printingStatus = PrintingStatus.INSERTED;
        this.modifiedAt = LocalDateTime.now();
    }
}
