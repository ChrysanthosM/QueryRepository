package org.masouras.squad.printing.mssql.schema.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.control.LetterType;
import org.masouras.squad.printing.mssql.schema.jpa.control.LetterTypeConverter;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LetterSetUpKey implements Serializable {
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private LetterType letterType;

    @Column(name = "SEQ_NO", nullable = false)
    private int seqNo;
}
