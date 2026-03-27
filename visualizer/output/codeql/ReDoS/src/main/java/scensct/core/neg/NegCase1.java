// A regular expression term that does not contain ambiguous nested quantifiers or problematic alternations within an infinite repetition should not be flagged as causing exponential backtracking.
package scensct.core.neg;

import java.util.regex.Pattern;

public class NegCase1 {
    public static void main(String[] args) {
        // Simple literal pattern with no quantifiers: no possibility of exponential backtracking
        Pattern p = Pattern.compile("abc");
        // Finite repetition with no nesting: safe
        Pattern p2 = Pattern.compile("a{3,5}");
        // Alternation outside infinite repetition: safe
        Pattern p3 = Pattern.compile("(a|b)c*");
        // Infinite repetition with no ambiguous inner quantifiers: safe
        Pattern p4 = Pattern.compile("(ab)*");
    }
}