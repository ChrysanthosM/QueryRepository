package org.masouras.squad.printing.mssql.schema.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PrintingFilesTable")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PrintingFilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NonNull
    @Lob
    @Column(name = "CONTENT_BASE64", nullable = false)
    private String contentBase64;
}
