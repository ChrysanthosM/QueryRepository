package org.masouras.printing.sqlite.schema.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.masouras.printing.sqlite.schema.jpa.control.ContentType;
import org.masouras.printing.sqlite.schema.jpa.control.ContentTypeConverter;

import java.time.LocalDateTime;

@Entity
@Table(name = "PrintingDataTable")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PrintingDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSSS")
    @Column(name = "CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime currentTimestamp;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACTIVITY_ID", nullable = false)
    private ActivityEntity activity;

    @NonNull
    @Convert(converter = ContentTypeConverter.class)
    @Column(name = "CONTENT_TYPE", nullable = false, length = 5)
    private ContentType contentType;

    @NonNull
    @Lob
    @Column(name = "CONTENT_BASE64", nullable = false)
    private String contentBase64;
}
