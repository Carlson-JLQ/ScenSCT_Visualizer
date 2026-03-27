// A regular expression term that does not contain ambiguous nested quantifiers or problematic alternations within an infinite repetition should not be flagged as causing exponential backtracking.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase1_Var5 {
    private static Pattern createSafePattern() {
        return Pattern.compile("(ab)*");
    }

    public static void main(String[] args) {
        // Inline pattern creation with method call
        Pattern p = Pattern.compile("abc");
        Pattern p2 = Pattern.compile("a{3,5}");
        Pattern p3 = Pattern.compile("(a|b)c*");
        // Move one pattern to a separate method
        Pattern p4 = createSafePattern();
    }
}