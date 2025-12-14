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
public enum PrintingStatus {
    INSERTED(DbFieldValues.ValuesForPrintingStatus.INSERTED.getValue()),
    VALIDATED(DbFieldValues.ValuesForPrintingStatus.VALIDATED.getValue()),
    PROCESSED(DbFieldValues.ValuesForPrintingStatus.PROCESSED.getValue()),
    PRINTED(DbFieldValues.ValuesForPrintingStatus.PRINTED.getValue()),
    DUMMY(DbFieldValues.ValuesForPrintingStatus.DUMMY.getValue()),
    ERROR(DbFieldValues.ValuesForPrintingStatus.ERROR.getValue()),
    ;
    private final String code;

    private static final Map<String, PrintingStatus> CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(PrintingStatus::getCode, e -> e));
    public static PrintingStatus getFromCode(@Nullable String code) {
        return StringUtils.isBlank(code) ? null : CODE_MAP.getOrDefault(code, null);
    }
}
