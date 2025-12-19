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
public enum ValidFlag {
    ENABLED(DbFieldValues.ValuesForValidFlag.ENABLED.getValue()),
    OPTIONAL(DbFieldValues.ValuesForValidFlag.OPTIONAL.getValue()),
    STRICT(DbFieldValues.ValuesForValidFlag.STRICT.getValue()),
    DISABLED(DbFieldValues.ValuesForValidFlag.DISABLED.getValue()),
    ;
    private final String code;

    private static final Map<String, ValidFlag> CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(ValidFlag::getCode, e -> e));
    public static ValidFlag getFromCode(@Nullable String code) {
        return StringUtils.isBlank(code) ? null : CODE_MAP.getOrDefault(code, null);
    }
}
