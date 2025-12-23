package org.masouras.squad.printing.mssql.schema.jpa.projection;

import org.masouras.squad.printing.mssql.schema.jpa.control.*;

public interface PrintingLetterSetUpProjection {
    ActivityType getActivityType();
    ContentType getContentType();
    LetterType getLetterType();
    XslType getXslType();
    RendererType getRendererType();
    ValidFlag getValidFlag();
}
