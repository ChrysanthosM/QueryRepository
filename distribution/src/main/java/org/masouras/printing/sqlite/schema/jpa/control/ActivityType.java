package org.masouras.printing.sqlite.schema.jpa.control;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum ActivityType {
    NEW_ENTRY_XML("10001"),
    ;
    private final String code;

    private static final Map<String, ActivityType> CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(ActivityType::getCode, e -> e));
    public static ActivityType getFromCode(@Nullable String code) {
        return StringUtils.isBlank(code) ? null : CODE_MAP.getOrDefault(code, null);
    }
}
