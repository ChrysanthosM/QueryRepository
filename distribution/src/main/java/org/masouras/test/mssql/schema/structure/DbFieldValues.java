package org.masouras.test.mssql.schema.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.masouras.base.annotation.J2SqlFieldValues;
import org.masouras.core.ValueForBase;

@J2SqlFieldValues("mssql")
public class DbFieldValues {
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
