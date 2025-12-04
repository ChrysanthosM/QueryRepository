package org.masouras.printing.mssql.schema.jpa.control;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ActivityTypeConverter implements AttributeConverter<ActivityType, String> {

    @Override
    public String convertToDatabaseColumn(ActivityType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public ActivityType convertToEntityAttribute(String dbData) {
        return ActivityType.getFromCode(dbData);
    }
}
