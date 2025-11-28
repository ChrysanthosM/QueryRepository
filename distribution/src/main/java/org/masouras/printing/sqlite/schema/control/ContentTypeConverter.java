package org.masouras.printing.sqlite.schema.control;

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
        return ContentType.fromCode(dbData);
    }
}
