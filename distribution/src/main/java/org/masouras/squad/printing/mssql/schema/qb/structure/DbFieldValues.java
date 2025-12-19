package org.masouras.squad.printing.mssql.schema.qb.structure;

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
        XML_POLICY("10001");
        private final DbField forDbField = DbField.CONTENT_TYPE;
        private final String value;
    }

    @Getter @AllArgsConstructor
    public enum ValuesForActivityType implements ValueForBase {
        QUOTATION_NEW("10001");
        private final DbField forDbField = DbField.ACTIVITY_TYPE;
        private final String value;
    }

    @Getter @AllArgsConstructor
    public enum ValuesForLetterType implements ValueForBase {
        POLICY("10001");
        private final DbField forDbField = DbField.LETTER_TYPE;
        private final String value;
    }

    @Getter @AllArgsConstructor
    public enum ValuesForXslType implements ValueForBase {
        POLICY("POLICY_XSL");
        private final DbField forDbField = DbField.XSL_TYPE;
        private final String value;
    }

    @Getter @AllArgsConstructor
    public enum ValuesForPrintingStatus implements ValueForBase {
        INSERTED("0"), VALIDATED("1"), PROCESSED("2"), PRINTED("3"), DUMMY("8"), ERROR("9");
        private final DbField forDbField = DbField.PRINTING_STATUS;
        private final String value;
    }

    @Getter @AllArgsConstructor
    public enum ValuesForValidFlag implements ValueForBase {
        ENABLED("1"), OPTIONAL("2"), STRICT("3"), DISABLED("9");
        private final DbField forDbField = DbField.VALID_FLAG;
        private final String value;
    }
}
