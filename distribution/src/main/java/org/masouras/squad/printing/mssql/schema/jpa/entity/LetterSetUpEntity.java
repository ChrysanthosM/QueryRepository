package org.masouras.squad.printing.mssql.schema.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.control.*;

@Entity
@Table(name = "LetterSetUpTable")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LetterSetUpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NonNull
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private ContentType letterType;

    @Column(name = "SEQ_NO")
    private int seqNo;

    @NonNull
    @Convert(converter = XslTypeConverter.class)
    @Column(name = "XSL_TYPE", nullable = false, length = 50)
    private XslType xslType;

    @NonNull
    @Convert(converter = ValidFlagConverter.class)
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
    private String validFlag;
}

