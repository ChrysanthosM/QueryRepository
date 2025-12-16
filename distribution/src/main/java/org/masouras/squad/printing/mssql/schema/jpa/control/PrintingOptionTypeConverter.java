package org.masouras.squad.printing.mssql.schema.jpa.control;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PrintingOptionTypeConverter implements AttributeConverter<PrintingOptionType, String> {

    @Override
    public String convertToDatabaseColumn(PrintingOptionType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public PrintingOptionType convertToEntityAttribute(String dbData) {
        return PrintingOptionType.getFromCode(dbData);
    }
}
