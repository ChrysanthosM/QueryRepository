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
public enum RendererType {
    FOP(DbFieldValues.ValuesForRenderType.FOP.getValue()),
    OPEN_HTML_TO_PDF(DbFieldValues.ValuesForRenderType.OPEN_HTML_TO_PDF.getValue()),
    FLYING_SAUCER(DbFieldValues.ValuesForRenderType.FLYING_SAUCER.getValue()),
    OPEN_PDF(DbFieldValues.ValuesForRenderType.OPEN_PDF.getValue()),
    ;
    private final String code;

    private static final Map<String, RendererType> CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(RendererType::getCode, e -> e));
    public static RendererType getFromCode(@Nullable String code) {
        return StringUtils.isBlank(code) ? null : CODE_MAP.getOrDefault(code, null);
    }
}
