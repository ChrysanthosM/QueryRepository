package org.masouras.core;

import com.google.common.base.Preconditions;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.context.annotation.Description;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface J2SQLShared {
    enum TypeOfSQLStatement {
        SQL_SELECT,
        SQL_DELETE,
        SQL_UPDATE,
        SQL_INSERT
    }

    private static List<SQLFieldFromPairOfTableField> fromPrefix(@NonNull PFX prefix, @NonNull PairOfTableField... prefixedDbF) {
        return Stream.of(prefixedDbF)
                .map(f -> new SQLFieldFromPairOfTableField(f, null, prefix.name().concat(".")))
                .toList();
    }
    enum PFX {
        A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, AA, AB, AC, AD, AE, AF, AG, AH, AI, AJ, AK, AL, AM, AN, AO, AP, AQ, AR, AS, AT, AU, AV, AW, AX, AY, AZ,
        T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, TA, TB, TC, TD, TE, TF, TG, TH, TI, TJ, TK, TL, TM, TN, TO, TP, TQ, TR, TS, TT, TU, TV, TW, TX, TY, TZ,
        J0, J1, J2, J3, J4, J5, J6, J7, J8, J9, JA, JB, JC, JD, JE, JF, JG, JH, JI, JJ, JK, JL, JM, JN, JO, JP, JQ, JR, JS, JT, JU, JV, JW, JX, JY, JZ,
        ;
        public static SQLFieldFromPairOfTableField a0(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A0,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a1(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A1,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a2(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A2,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a3(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A3,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a4(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A4,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a5(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A5,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a6(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A6,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a7(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A7,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a8(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A8,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField a9(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.A9,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField aa(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AA,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ab(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AB,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ac(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AC,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ad(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AD,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ae(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AE,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField af(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AF,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ag(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AG,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ah(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AH,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ai(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AI,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField aj(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AJ,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ak(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AK,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField al(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AL,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField am(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AM,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField an(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AN,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ao(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AO,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ap(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AP,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField aq(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AQ,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ar(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AR,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField as(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AS,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField at(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AT,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField au(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AU,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField av(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AV,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField aw(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AW,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ax(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AX,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ay(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AY,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField az(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.AZ,prefixedDbF).getFirst();}

        public static SQLFieldFromPairOfTableField t0(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T0,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t1(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T1,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t2(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T2,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t3(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T3,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t4(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T4,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t5(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T5,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t6(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T6,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t7(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T7,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t8(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T8,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField t9(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.T9,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ta(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TA,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tb(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TB,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tc(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TC,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField td(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TD,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField te(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TE,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tf(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TF,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tg(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TG,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField th(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TH,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ti(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TI,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tj(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TJ,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tk(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TK,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tl(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TL,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tm(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TM,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tn(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TN,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField to(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TO,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tp(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TP,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tq(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TQ,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tr(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TR,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ts(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TS,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tt(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TT,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tu(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TU,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tv(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TV,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tw(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TW,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tx(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TX,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ty(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TY,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField tz(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.TZ,prefixedDbF).getFirst();}

        public static SQLFieldFromPairOfTableField j0(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J0,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j1(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J1,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j2(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J2,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j3(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J3,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j4(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J4,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j5(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J5,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j6(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J6,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j7(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J7,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j8(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J8,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField j9(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.J9,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ja(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JA,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jb(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JB,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jc(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JC,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jd(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JD,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField je(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JE,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jf(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JF,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jg(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JG,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jh(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JH,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ji(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JI,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jj(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JJ,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jk(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JK,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jl(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JL,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jm(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JM,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jn(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JN,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jo(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JO,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jp(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JP,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jq(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JQ,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jr(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JR,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField js(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JS,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jt(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JT,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField ju(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JU,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jv(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JV,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jw(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JW,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jx(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JX,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jy(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JY,prefixedDbF).getFirst();}
        public static SQLFieldFromPairOfTableField jz(@NonNull PairOfTableField prefixedDbF){return fromPrefix(PFX.JZ,prefixedDbF).getFirst();}

        public static List<SQLFieldFromPairOfTableField> a0(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A0,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a1(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A1,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a2(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A2,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a3(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A3,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a4(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A4,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a5(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A5,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a6(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A6,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a7(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A7,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a8(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A8,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> a9(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.A9,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> aa(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AA,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ab(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AB,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ac(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AC,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ad(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AD,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ae(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AE,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> af(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AF,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ag(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AG,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ah(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AH,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ai(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AI,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> aj(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AJ,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ak(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AK,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> al(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AL,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> am(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AM,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> an(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AN,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ao(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AO,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ap(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AP,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> aq(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AQ,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ar(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AR,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> as(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AS,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> at(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AT,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> au(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AU,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> av(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AV,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> aw(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AW,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ax(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AX,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ay(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AY,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> az(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.AZ,prefixedDbF);}

        public static List<SQLFieldFromPairOfTableField> t0(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T0,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t1(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T1,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t2(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T2,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t3(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T3,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t4(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T4,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t5(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T5,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t6(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T6,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t7(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T7,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t8(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T8,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> t9(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.T9,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ta(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TA,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tb(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TB,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tc(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TC,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> td(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TD,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> te(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TE,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tf(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TF,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tg(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TG,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> th(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TH,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ti(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TI,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tj(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TJ,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tk(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TK,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tl(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TL,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tm(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TM,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tn(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TN,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> to(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TO,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tp(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TP,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tq(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TQ,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tr(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TR,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ts(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TS,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tt(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TT,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tu(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TU,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tv(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TV,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tw(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TW,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tx(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TX,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ty(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TY,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> tz(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.TZ,prefixedDbF);}

        public static List<SQLFieldFromPairOfTableField> j0(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J0,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j1(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J1,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j2(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J2,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j3(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J3,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j4(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J4,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j5(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J5,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j6(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J6,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j7(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J7,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j8(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J8,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> j9(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.J9,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ja(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JA,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jb(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JB,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jc(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JC,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jd(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JD,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> je(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JE,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jf(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JF,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jg(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JG,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jh(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JH,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ji(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JI,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jj(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JJ,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jk(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JK,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jl(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JL,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jm(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JM,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jn(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JN,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jo(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JO,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jp(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JP,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jq(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JQ,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jr(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JR,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> js(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JS,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jt(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JT,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> ju(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JU,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jv(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JV,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jw(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JW,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jx(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JX,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jy(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JY,prefixedDbF);}
        public static List<SQLFieldFromPairOfTableField> jz(@NonNull PairOfTableField... prefixedDbF){return fromPrefix(PFX.JZ,prefixedDbF);}
    }




    static MutablePair<Object, SortOrder> asc(@NonNull Object addOrderBy) { return MutablePair.of(addOrderBy, SortOrder.ASCENDING); }
    static MutablePair<Object, SortOrder> desc(@NonNull Object addOrderBy) { return MutablePair.of(addOrderBy, SortOrder.DESCENDING); }


    static WhereBase not(@NonNull WhereBase filter) {
        ((AbstractFilter) filter).setInvertSelection(true);
        return filter;
    }

    //-------Create Filters
    @UtilityClass
    class Filter {
        @Description("Filter Where Value")
        public static WhereBase whereValue(@NonNull Object whereObject, @Nullable LinSQL.TypeOfComparison typeOfComparison, @Nullable Object compareValue) {
            return new ValueWhere(whereObject, typeOfComparison, compareValue);
        }

        @Description("Filter Where IN Values")
        public static WhereBase whereInValues(@NonNull Object whereObject, @NonNull List<Object> inValues) {
            return new InValuesWhere(whereObject, inValues);
        }
        @Description("Filter Where IN Values")
        public static WhereBase whereInValues(@NonNull Object whereObject, @NonNull Object... inValues) {
            return new InValuesWhere(whereObject, List.of(inValues));
        }

        @Description("Filter Where BETWEEN Values")
        public static WhereBase whereBetweenValues(@NonNull Object whereObject, @NonNull Object fromObject, @NonNull Object toObject) {
            return new BetweenValuesWhere(whereObject, MutablePair.of(fromObject, toObject));
        }

        @Description("Filter Where LIKE Values")
        public static WhereBase whereLikeValue(@NonNull Object whereObject, @Nullable String compareValue) {
            return new LikeValueWhere(whereObject, compareValue, null, null);
        }
        @Description("Filter Where LIKE Values")
        public static WhereBase whereLikeValue(@NonNull Object whereObject, @Nullable String compareValue, @Nullable String escapeLeft, @Nullable String escapeRight) {
            return new LikeValueWhere(whereObject, compareValue, escapeLeft, escapeRight);
        }

        @Description("Filter Where IN SubSelect")
        public static WhereBase whereInSubSelect(@NonNull Object whereObject, @NonNull String inSubSelect) {
            return new InSubSelectWhere(whereObject, inSubSelect);
        }

        @Description("Filter Where EXISTS")
        public static WhereBase whereExists(@NonNull String existQuery) {
            return new ExistsWhere(existQuery);
        }
        @Description("Filter Where EXISTS")
        public static WhereBase whereExists(@NonNull LinSQL existQuery) {
            return new ExistsWhere(existQuery.getSQL());
        }
    }


    //-------SQLFunctions
    @AllArgsConstructor
    final class SQLFunctionObject implements DeployFiltersBase, ProvideDataTypeForSQLBase {
        private final SQLFunction sqlFunction;
        private static SQLFunctionObject of(SQLFunction sqlFunction) { return new SQLFunctionObject(sqlFunction); }
        public Object getSqlFunction() { return sqlFunction; }

        @Override
        public Boolean getInQuotesRequirement() {
            return this.sqlFunction.getTypeOfSQLFunction().getInQuotesRequirement();
        }
    }

    static SQLFunctionObject TRIM(@NonNull Object arg) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.TRIM, arg)); }
    static SQLFunctionObject LTRIM(@NonNull Object arg) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.LTRIM, arg)); }
    static SQLFunctionObject RTRIM(@NonNull Object arg) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.RTRIM, arg)); }
    static SQLFunctionObject LENGTH(@NonNull Object arg) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.LENGTH, arg)); }
    static SQLFunctionObject UPPER(@NonNull Object arg) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.UPPER, arg)); }
    static SQLFunctionObject LOWER(@NonNull Object arg) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.LOWER, arg)); }
    static SQLFunctionObject INITCAP(@NonNull Object arg) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.INITCAP, arg)); }
    static SQLFunctionObject SPACE(int numOfSpaces) {
        Preconditions.checkArgument(numOfSpaces >= 0);
        return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.SPACE, numOfSpaces));
    }
    static SQLFunctionObject INSTR(@NonNull Object arg, @NonNull Object find) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.INSTR, Stream.of(arg, find).toArray())); }
    static SQLFunctionObject LEFT(@NonNull Object arg, int len) {
        Preconditions.checkArgument(len > 0);
        return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.LEFT, Stream.of(arg, len).toArray()));
    }
    static SQLFunctionObject RIGHT(@NonNull Object arg, int len) {
        Preconditions.checkArgument(len > 0);
        return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.RIGHT, Stream.of(arg, len).toArray()));
    }
    static SQLFunctionObject REPEAT(@NonNull Object arg, int times) {
        Preconditions.checkArgument(times > 0);
        return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.REPEAT, Stream.of(arg, times).toArray()));
    }
    static SQLFunctionObject REPLACE(@NonNull Object arg, @NonNull Object find, @NonNull Object replaceWith) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.REPLACE, Stream.of(arg, find, replaceWith).toArray())); }
    static SQLFunctionObject SUBSTR(@NonNull Object arg, int from, int len) {
        Preconditions.checkArgument(from > 0);
        Preconditions.checkArgument(len > 0);
        return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.SUBSTR, Stream.of(arg, from, len).toArray()));
    }
    static SQLFunctionObject LPAD(@NonNull Object arg, @NonNull Object totalLength, @NonNull Object leadingChar) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.RPAD, Stream.of(arg, totalLength, leadingChar).toArray())); }
    static SQLFunctionObject RPAD(@NonNull Object arg, @NonNull Object totalLength, @NonNull Object trailingChar) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.RPAD, Stream.of(arg, totalLength, trailingChar).toArray())); }
    static SQLFunctionObject CONCAT(@NonNull Object... args) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.CONCAT, args)); }
    static SQLFunctionObject TRANSLATE(@NonNull Object arg, @NonNull Object find, @NonNull Object replaceWith, @Nullable Object pad) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.TRANSLATE, Stream.of(arg, find, replaceWith, pad).toArray())); }

    static SQLFunctionObject CASE(Boolean inQuotesRequirement, Object caseExpression, Object elseExpression, WhenBase... args) {
        List<Object> argList = new ArrayList<>(List.of(inQuotesRequirement, Optional.ofNullable(caseExpression), elseExpression));
        argList.addAll(Arrays.asList(args));
        return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.CASE, argList.toArray()));
    }
    static SQLFunctionObject CASE1s(@Nullable Object elseExpression, @NonNull WhenBase... args) { return CASE(true, null, elseExpression, args); }
    static SQLFunctionObject CASE1n(@Nullable Object elseExpression, @NonNull WhenBase... args) { return CASE(false, null, elseExpression, args); }
    static WhenBase WHEN(@NonNull WhereBase searchCondition, @NonNull Object thenExpression) { return new WhenThenSearched(searchCondition, thenExpression); }
    static SQLFunctionObject CASE2s(@NonNull Object caseExpression, @Nullable Object elseExpression, @NonNull WhenBase... args) { return CASE(true, caseExpression, elseExpression, args); }
    static SQLFunctionObject CASE2n(@NonNull Object caseExpression, @Nullable Object elseExpression, @NonNull WhenBase... args) { return CASE(false, caseExpression, elseExpression, args); }
    static WhenBase WHEN(@NonNull Object whenExpression, @NonNull Object thenExpression) { return new WhenThenSimple(whenExpression, thenExpression); }

    static SQLFunctionObject MIN(@Nullable Object arg, boolean distinct) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.MIN, Stream.of(distinct, arg).toArray())); }
    static SQLFunctionObject MIN(boolean distinct) { return MIN(null, distinct); }
    static SQLFunctionObject MIN(@Nullable Object arg) { return MIN(arg, false); }
    static SQLFunctionObject MIN() { return MIN(null, false); }
    static SQLFunctionObject MAX(@Nullable Object arg, boolean distinct) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.MAX, Stream.of(distinct, arg).toArray())); }
    static SQLFunctionObject MAX(boolean distinct) { return MAX(null, distinct); }
    static SQLFunctionObject MAX(@Nullable Object arg) { return MAX(arg, false); }
    static SQLFunctionObject MAX() { return MAX(null, false); }
    static SQLFunctionObject AVG(@Nullable Object arg, boolean distinct) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.AVG, Stream.of(distinct, arg).toArray())); }
    static SQLFunctionObject AVG(boolean distinct) { return AVG(null, distinct); }
    static SQLFunctionObject AVG(@Nullable Object arg) { return AVG(arg, false); }
    static SQLFunctionObject AVG() { return AVG(null, false); }
    static SQLFunctionObject COUNT(@Nullable Object arg, boolean distinct) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.COUNT, Stream.of(distinct, arg).toArray())); }
    static SQLFunctionObject COUNT(boolean distinct) { return COUNT(null, distinct); }
    static SQLFunctionObject COUNT(@Nullable Object arg) { return COUNT(arg, false); }
    static SQLFunctionObject COUNT() { return COUNT(null, false); }
    static SQLFunctionObject COUNT_BIG(@Nullable Object arg, boolean distinct) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.COUNT_BIG, Stream.of(distinct, arg).toArray())); }
    static SQLFunctionObject COUNT_BIG(boolean distinct) { return COUNT_BIG(null, distinct); }
    static SQLFunctionObject COUNT_BIG(@Nullable Object arg) { return COUNT_BIG(arg, false); }
    static SQLFunctionObject COUNT_BIG() { return COUNT_BIG(null, false); }
    static SQLFunctionObject SUM(@Nullable Object arg, boolean distinct) { return SQLFunctionObject.of(DeploySQLFunctionsBase.create(DeploySQLFunctionsBase.TypeOfSQLFunction.SUM, Stream.of(distinct, arg).toArray())); }
    static SQLFunctionObject SUM(boolean distinct) { return SUM(null, distinct); }
    static SQLFunctionObject SUM(@Nullable Object arg) { return SUM(arg, false); }
    static SQLFunctionObject SUM() { return SUM(null, false); }

}
