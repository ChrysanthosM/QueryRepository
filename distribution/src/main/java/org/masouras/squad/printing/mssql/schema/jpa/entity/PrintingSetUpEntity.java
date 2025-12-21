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
    @EmbeddedId
    @NonNull
    private PrintingSetUpKey id;

    @NonNull
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private LetterType letterType;
}

