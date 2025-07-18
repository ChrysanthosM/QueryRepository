package org.masouras.core;


import org.masouras.base.builder.BaseDbField;

public interface ValueForBase {
    BaseDbField getForDbField();
    String getValue();
}
