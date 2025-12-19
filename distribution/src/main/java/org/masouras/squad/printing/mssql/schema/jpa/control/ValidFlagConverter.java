package org.masouras.squad.printing.mssql.schema.jpa.control;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ValidFlagConverter implements AttributeConverter<ValidFlag, String> {

    @Override
    public String convertToDatabaseColumn(ValidFlag attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public ValidFlag convertToEntityAttribute(String dbData) {
        return ValidFlag.getFromCode(dbData);
    }
}
