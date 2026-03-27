// A regular expression term that does not contain ambiguous nested quantifiers or problematic alternations within an infinite repetition should not be flagged as causing exponential backtracking.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Use try-catch block around pattern creation (no effect on safety)
        try {
            Pattern p = Pattern.compile("abc");
        } catch (Exception e) {
            // ignore
        }

        // Finite repetition expressed as multiple fixed repetitions
        Pattern p2 = Pattern.compile("a{3}a{0,2}");

        // Alternation with infinite repetition of a single char (safe)
        Pattern p3 = Pattern.compile("[ab]" + "c*");

        // Infinite repetition of a non-capturing group
        Pattern p4 = Pattern.compile("(?:ab)*");
    }
}