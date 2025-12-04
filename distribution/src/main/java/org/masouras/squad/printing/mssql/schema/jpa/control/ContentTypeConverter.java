package org.masouras.squad.printing.mssql.schema.jpa.control;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ContentTypeConverter implements AttributeConverter<ContentType, String> {

    @Override
    public String convertToDatabaseColumn(ContentType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public ContentType convertToEntityAttribute(String dbData) {
        return ContentType.getFromCode(dbData);
    }
}
