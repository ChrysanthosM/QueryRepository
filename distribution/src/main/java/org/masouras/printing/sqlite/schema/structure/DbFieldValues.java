package org.masouras.printing.sqlite.schema.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.masouras.base.annotation.J2SqlFieldValues;
import org.masouras.core.ValueForBase;

@J2SqlFieldValues("sqlite")
public class DbFieldValues {

    @Getter @AllArgsConstructor
    public enum ValuesForOptionType implements ValueForBase {
        SYS_PARAM("O01"), FORM_SETTING("O02");
        private final DbField forDbField = DbField.OPTION_TYPE;
        private final String value;
    }

    @Getter @AllArgsConstructor
    public enum ValuesForContentType implements ValueForBase {
        XML("xml");
        private final DbField forDbField = DbField.CONTENT_TYPE;
        private final String value;
    }

}
