package org.masouras.squad.printing.mssql.schema.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.control.*;

@Entity
@Table(name = "LetterSetUpTable")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LetterSetUpEntity {
    @EmbeddedId
    @NonNull
    private LetterSetUpKey id;

    @NonNull
    @Convert(converter = XslTypeConverter.class)
    @Column(name = "XSL_TYPE", nullable = false, length = 50)
    private XslType xslType;

    @NonNull
    @Convert(converter = RenderTypeConverter.class)
    @Column(name = "RENDER_TYPE", nullable = false, length = 3)
    private RendererType renderType;

    @NonNull
    @Convert(converter = ValidFlagConverter.class)
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
    private ValidFlag validFlag;
}

