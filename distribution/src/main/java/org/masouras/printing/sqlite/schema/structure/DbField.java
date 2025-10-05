package org.masouras.printing.sqlite.schema.structure;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.masouras.base.builder.BaseDbField;
import org.masouras.base.builder.ConfigDbField;
import org.masouras.base.builder.DbFieldDataType;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.masouras.base.builder.DbFieldDataType.DATATYPE_INTEGER;
import static org.masouras.base.builder.DbFieldDataType.DATATYPE_TEXT;

@Getter
public enum DbField implements BaseDbField {
    REC_ID("ID", DATATYPE_INTEGER),
    CURRENT_TIMESTAMP("CURRENT_TIMESTAMP", DATATYPE_TEXT),

    ACTIVITY_ID("ACTIVITY_ID", DATATYPE_INTEGER),
    USER_STAMP("USER_STAMP", DATATYPE_TEXT),
    DATE_STAMP("DATE_STAMP", DATATYPE_TEXT),
    PGM_STAMP("PGM_STAMP", DATATYPE_TEXT),

    OPTION_TYPE("OPTION_TYPE", DATATYPE_TEXT),
    OPTION_NAME("OPTION_NAME", DATATYPE_TEXT),
    OPTION_VALUE("OPTION_VALUE", DATATYPE_TEXT),
    OPTION_DETAILS("OPTION_DETAILS", DATATYPE_TEXT),

    CONTENT_BASE64("CONTENT_BASE64", DATATYPE_TEXT),
    CONTENT_TYPE("CONTENT_TYPE", DATATYPE_TEXT),

    ACTIVITY_TYPE("ACTIVITY_TYPE", DATATYPE_TEXT),

    ;

    private final ConfigDbField configDbField;

    DbField(String systemName) {
        this.configDbField = new ConfigDbField(systemName, null, null);
    }
    DbField(String systemName, DbFieldDataType fieldDataType) {
        this.configDbField = new ConfigDbField(
                systemName,
                fieldDataType,
                Arrays.stream(systemName.toLowerCase().split("_")).map(StringUtils::capitalize).collect(Collectors.joining(StringUtils.SPACE)));
    }
    DbField(String systemName, DbFieldDataType fieldDataType, String asAlias) {
        this.configDbField = new ConfigDbField(
                systemName,
                fieldDataType,
                asAlias);
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
    public Boolean getInQuotesRequirement() {
        return this.configDbField.fieldDataType().getInQuotesRequirement();
    }
}
