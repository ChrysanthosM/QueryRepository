package org.masouras.squad.printing.mssql.schema.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.control.PrintingOptionType;
import org.masouras.squad.printing.mssql.schema.jpa.control.PrintingOptionTypeConverter;

@Entity
@Table(name = "PrintingOptionsTable")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PrintingOptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NonNull
    @Convert(converter = PrintingOptionTypeConverter.class)
    @Column(name = "OPTION_TYPE", nullable = false, length = 3)
    private PrintingOptionType printingOptionType;

    @Column(name = "OPTION_NAME")
    private String printingOptionName;

    @Column(name = "OPTION_VALUE")
    private String printingOptionValue;

    @Column(name = "OPTION_DETAILS")
    private String printingOptionDetails;
}

