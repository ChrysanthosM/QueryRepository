package org.masouras.squad.printing.mssql.schema.jpa.mapper;

import org.masouras.squad.printing.mssql.schema.jpa.control.ContentType;
import org.masouras.squad.printing.mssql.schema.jpa.control.FileExtensionType;
import org.masouras.squad.printing.mssql.schema.jpa.control.PrintingStatus;
import org.masouras.squad.printing.mssql.schema.jpa.entity.ActivityEntity;
import org.masouras.squad.printing.mssql.schema.jpa.entity.PrintingDataEntity;
import org.masouras.squad.printing.mssql.schema.jpa.entity.PrintingFilesEntity;
import org.masouras.squad.printing.mssql.schema.qb.structure.DbField;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class PrintingDataRowMapper implements RowMapper<PrintingDataEntity> {

    @Override
    public PrintingDataEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PrintingDataEntity entity = new PrintingDataEntity();

        entity.setId(rs.getLong(DbField.REC_ID.systemName()));
        entity.setPrintingStatus(Objects.requireNonNull(PrintingStatus.getFromCode(rs.getString(DbField.PRINTING_STATUS.systemName()))));
        entity.setModifiedAt(rs.getTimestamp(DbField.MODIFIED_AT.systemName()).toLocalDateTime());

        ActivityEntity activity = new ActivityEntity();
        activity.setId(rs.getLong(DbField.ACTIVITY_ID.systemName()));
        entity.setActivity(activity);

        entity.setErrorMessage(rs.getString(DbField.ERROR_MESSAGE.systemName()));
        entity.setContentType(Objects.requireNonNull(ContentType.getFromCode(rs.getString(DbField.CONTENT_TYPE.systemName()))));
        entity.setFileExtensionType(Objects.requireNonNull(FileExtensionType.getFromCode(rs.getString(DbField.EXTENSION_TYPE.systemName()))));

        PrintingFilesEntity initialPrintingFilesEntity = new PrintingFilesEntity();
        initialPrintingFilesEntity.setId(rs.getLong(DbField.INITIAL_CONTENT_ID.systemName()));
        initialPrintingFilesEntity.setContentBase64(rs.getString(DbField.INITIAL_CONTENT_BASE64.systemName()));
        entity.setInitialContent(initialPrintingFilesEntity);

        PrintingFilesEntity validatedPrintingFilesEntity = new PrintingFilesEntity();
        long validatedId = rs.getLong(DbField.VALIDATED_CONTENT_ID.systemName());
        validatedPrintingFilesEntity.setId(rs.wasNull() ? null : validatedId);
        entity.setValidatedContent(validatedPrintingFilesEntity);

        PrintingFilesEntity finalPrintingFilesEntity = new PrintingFilesEntity();
        long finalId = rs.getLong(DbField.FINAL_CONTENT_ID.systemName());
        finalPrintingFilesEntity.setId(rs.wasNull() ? null : finalId);
        entity.setFinalContent(finalPrintingFilesEntity);

        return entity;
    }
}
