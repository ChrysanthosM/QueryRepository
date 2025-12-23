package org.masouras.squad.printing.mssql.schema.jpa.control;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RenderTypeConverter implements AttributeConverter<RendererType, String> {

    @Override
    public String convertToDatabaseColumn(RendererType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public RendererType convertToEntityAttribute(String dbData) {
        return RendererType.getFromCode(dbData);
    }
}
