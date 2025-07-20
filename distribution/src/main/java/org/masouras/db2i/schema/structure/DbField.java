package org.masouras.db2i.schema.structure;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.masouras.base.builder.BaseDbField;
import org.masouras.base.builder.ConfigDbField;
import org.masouras.base.builder.DbFieldDataType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.masouras.base.builder.DbFieldDataType.DATATYPE_INTEGER;
import static org.masouras.base.builder.DbFieldDataType.DATATYPE_TEXT;

@Getter
public enum DbField implements BaseDbField {
    REC_ID("Sys_RecID", DATATYPE_INTEGER),
    USER_STAMP("Sys_UserStamp", DATATYPE_TEXT),
    DATE_STAMP("Sys_DateStamp", DATATYPE_TEXT),

    USER_NAME("Sys_UserName", DATATYPE_TEXT),
    USER_PASSWORD("Sys_Password", DATATYPE_TEXT),

    ENTITY_TYPE("Sys_EntityType", DATATYPE_TEXT),
    ENTITY_NUMBER("Sys_EntityNumber", DATATYPE_INTEGER),

    OPTION_TYPE("Sys_OptionType", DATATYPE_TEXT),
    OPTION_NAME("Sys_OptionName", DATATYPE_TEXT),
    OPTION_VALUE("Sys_OptionValue", DATATYPE_TEXT),
    OPTION_DETAILS("Sys_OptionDetails", DATATYPE_TEXT),

    ;

    private final ConfigDbField configDbField;

    DbField(String systemName) {
        this.configDbField = new ConfigDbField(systemName, null, null, Collections.emptyList());
    }
    DbField(String systemName, DbFieldDataType fieldDataType) {
        this.configDbField = new ConfigDbField(
                systemName,
                fieldDataType,
                Arrays.stream(systemName.toLowerCase().split("_")).map(StringUtils::capitalize).collect(Collectors.joining(StringUtils.SPACE)),
                Collections.singletonList(DbFieldValues.getAcceptedValues(this)));
    }
    DbField(String systemName, DbFieldDataType fieldDataType, String asAlias) {
        this.configDbField = new ConfigDbField(
                systemName,
                fieldDataType,
                asAlias,
                Collections.singletonList(DbFieldValues.getAcceptedValues(this)));
    }

    @Override
    public String systemName() {
        return this.configDbField.systemName();
    }
    @Override
    public DbFieldDataType fieldDataType() {
        return this.configDbField.fieldDataType();
    }
    @Override
    public String asAlias() {
        return this.configDbField.asAlias();
    }
    @Override
    public List<Object> acceptedValues() {
        return this.configDbField.acceptedValues();
    }

    @Override
    public Boolean getInQuotesRequirement() {
        return this.configDbField.fieldDataType().getInQuotesRequirement();
    }
}
