package org.masouras.squad.printing.mssql.schema.jpa.control;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PrintingStatusConverter implements AttributeConverter<PrintingStatus, String> {

    @Override
    public String convertToDatabaseColumn(PrintingStatus attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public PrintingStatus convertToEntityAttribute(String dbData) {
        return PrintingStatus.getFromCode(dbData);
    }
}
