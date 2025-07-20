package org.masouras.mssql.schema.structure;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;
import org.masouras.base.builder.BaseDbField;
import org.masouras.core.ValueForBase;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public final class DbFieldValues {
    private static final ConcurrentHashMap<BaseDbField, List<String>> bufferAcceptedValues = new ConcurrentHashMap<>();
    public static List<String> getAcceptedValues(@NonNull BaseDbField forField) {
        return bufferAcceptedValues.getOrDefault(forField, Collections.emptyList());
    }

    @PostConstruct
    public void init() {
        List<Class<?>> dbfWithValues = Arrays.asList(DbFieldValues.class.getDeclaredClasses());
        if (CollectionUtils.isNotEmpty(dbfWithValues)) {
            dbfWithValues.parallelStream().filter(e -> e.isEnum() && ValueForBase.class.isAssignableFrom(e)).forEach(e -> {
                List<?> dbfValuesList = Arrays.asList(e.getEnumConstants());
                if (CollectionUtils.isNotEmpty(dbfValuesList)) {
                    dbfValuesList.parallelStream().forEach(dbf -> bufferAcceptedValues.put(
                            ((ValueForBase) dbf).getForDbField(),
                            dbfValuesList.stream().map(v -> ((ValueForBase) v).getValue()).toList()));
                }
            });
        }
    }

    @Getter @AllArgsConstructor
    public enum ValuesForEntityType implements ValueForBase {
        TEMP_STUCK("E01"), SURROGATE_NUM("E02");
        private final DbField forDbField = DbField.ENTITY_TYPE;
        private final String value;
    }

    @Getter @AllArgsConstructor
    public enum ValuesForOptionType implements ValueForBase {
        SYS_PARAM("O01"), FORM_SETTING("O02");
        private final DbField forDbField = DbField.OPTION_TYPE;
        private final String value;
    }
}
