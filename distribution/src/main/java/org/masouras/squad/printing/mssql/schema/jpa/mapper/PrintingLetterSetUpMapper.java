package org.masouras.squad.printing.mssql.schema.jpa.mapper;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.masouras.squad.printing.mssql.schema.jpa.control.*;
import org.masouras.squad.printing.mssql.schema.jpa.projection.PrintingLetterSetUpProjectionImplementor;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbField;

import java.util.List;
import java.util.Map;

@UtilityClass
public class PrintingLetterSetUpMapper {
    public static @NonNull List<PrintingLetterSetUpProjectionImplementor> getPrintingLetterSetUpProjectionImplementors(List<Map<String, Object>> rows) {
        return rows.stream()
                .map(row -> new PrintingLetterSetUpProjectionImplementor(
                        ActivityType.getFromCode((String) row.get(DbField.ACTIVITY_TYPE.systemName())),
                        ContentType.getFromCode((String) row.get(DbField.CONTENT_TYPE.systemName())),
                        LetterType.getFromCode((String) row.get(DbField.LETTER_TYPE.systemName())),
                        XslType.getFromCode((String) row.get(DbField.XSL_TYPE.systemName())),
                        RendererType.getFromCode((String) row.get(DbField.RENDER_TYPE.systemName())),
                        ValidFlag.getFromCode((String) row.get(DbField.VALID_FLAG.systemName()))
                ))
                .toList();
    }
}
