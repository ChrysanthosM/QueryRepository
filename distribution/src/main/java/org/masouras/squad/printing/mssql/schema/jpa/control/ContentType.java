package org.masouras.squad.printing.mssql.schema.jpa.control;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbFieldValues;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum ContentType {
    XML_POLICY(DbFieldValues.ValuesForContentType.XML_POLICY.getValue()),
    ;
    private final String code;

    private static final Map<String, ContentType> CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(ContentType::getCode, e -> e));
    public static ContentType getFromCode(@Nullable String code) {
        return StringUtils.isBlank(code) ? null : CODE_MAP.getOrDefault(code, null);
    }
}
