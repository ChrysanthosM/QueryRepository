package org.masouras.base.builder;

import java.util.List;

public record ConfigDbField(String systemName,
                            DbFieldDataType fieldDataType,
                            String asAlias,
                            List<Object> acceptedValues) {
}
