package org.masouras.base.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DbFieldDataType {
    DATATYPE_TEXT(true),
    DATATYPE_INTEGER(false),
    DATATYPE_DOUBLE(false),
    DATATYPE_DATE(false),
    DATATYPE_BOOLEAN(false),
    DATATYPE_BINARY(false),
    ;

    private final Boolean inQuotesRequirement;
}
