package org.masouras.printing.sqlite.schema.control;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum ContentType {
    XML_POLICY("100", "10001"),
    ;
    private final String startsWith;
    private final String code;

    private static final Map<String, ContentType> CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(ContentType::getCode, e -> e));
    private static final Map<String, ContentType> STARTS_WITH_MAP = Arrays.stream(values()).collect(Collectors.toMap(ContentType::getStartsWith, e -> e));
    public static ContentType fromCode(@Nullable String code) {
        return StringUtils.isBlank(code) ? null : CODE_MAP.getOrDefault(code, null);
    }
    public static ContentType fromStartsWith(@Nullable String startsWith) {
        return StringUtils.isBlank(startsWith) ? null : STARTS_WITH_MAP.getOrDefault(startsWith, null);
    }

}
