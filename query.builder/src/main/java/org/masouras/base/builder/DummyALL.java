package org.masouras.base.builder;

import lombok.Getter;

import java.util.List;

public final class DummyALL implements BaseDbField {
    @Getter
    private static final DummyALL dummyALL = new DummyALL();

    @Override
    public String systemName() {
        return "*";
    }
    @Override
    public DbFieldDataType fieldDataType() {
        return null;
    }
    @Override
    public String asAlias() {
        return null;
    }
    @Override
    public List<Object> acceptedValues() {
        return List.of();
    }

    @Override
    public Boolean getInQuotesRequirement() {
        return Boolean.FALSE;
    }

}
