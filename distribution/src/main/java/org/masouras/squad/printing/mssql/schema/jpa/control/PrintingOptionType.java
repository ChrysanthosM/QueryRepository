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
public enum PrintingOptionType {
    SYS_PARAM(DbFieldValues.ValuesForOptionType.SYS_PARAM.getValue()),
    FORM_SETTING(DbFieldValues.ValuesForOptionType.FORM_SETTING.getValue()),
    ;
    private final String code;

    private static final Map<String, PrintingOptionType> CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(PrintingOptionType::getCode, e -> e));
    public static PrintingOptionType getFromCode(@Nullable String code) {
        return StringUtils.isBlank(code) ? null : CODE_MAP.getOrDefault(code, null);
    }
}
