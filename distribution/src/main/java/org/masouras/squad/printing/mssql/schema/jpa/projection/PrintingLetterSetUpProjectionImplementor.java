package org.masouras.squad.printing.mssql.schema.jpa.projection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.control.*;

@RequiredArgsConstructor
@Getter
public class PrintingLetterSetUpProjectionImplementor implements PrintingLetterSetUpProjection {
    private final ActivityType activityType;
    private final ContentType contentType;
    private final LetterType letterType;
    private final XslType xslType;
    private final RendererType rendererType;
    private final ValidFlag validFlag;
}
