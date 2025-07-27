package org.masouras.base.builder;

public record ConfigDbField(String systemName,
                            DbFieldDataType fieldDataType,
                            String asAlias) {
}
