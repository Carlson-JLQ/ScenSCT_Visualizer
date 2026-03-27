// A regular expression term that does not contain ambiguous nested quantifiers or problematic alternations within an infinite repetition should not be flagged as causing exponential backtracking.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase1_Var3 {
    private static final String SAFE_LITERAL = "abc";
    private static final String FINITE_REP = "a{3,5}";
    private static final String ALT_OUTSIDE = "(a|b)c*";
    private static final String INF_SAFE = "(ab)*";

    public static void main(String[] args) {
        // All patterns from static final constants
        Pattern p = Pattern.compile(SAFE_LITERAL);
        Pattern p2 = Pattern.compile(FINITE_REP);
        Pattern p3 = Pattern.compile(ALT_OUTSIDE);
        Pattern p4 = Pattern.compile(INF_SAFE);
    }
}