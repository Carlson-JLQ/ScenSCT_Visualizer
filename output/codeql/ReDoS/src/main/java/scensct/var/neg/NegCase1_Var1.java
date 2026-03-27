// A regular expression term that does not contain ambiguous nested quantifiers or problematic alternations within an infinite repetition should not be flagged as causing exponential backtracking.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase1_Var1 {
    // Helper method to create patterns
    private static Pattern makePattern(String regex) {
        return Pattern.compile(regex);
    }

    public static void main(String[] args) {
        // Variant 1: Use helper method and string concatenation
        Pattern p = makePattern("ab" + "c");
        // Variant 2: Extract finite repetition to a constant
        final String finiteRep = "a{3,5}";
        Pattern p2 = Pattern.compile(finiteRep);
        // Variant 3: Use Pattern.matches for checking (still compiles pattern)
        boolean test = Pattern.matches("(a|b)c*", "acc");
        Pattern p3 = test ? Pattern.compile("(a|b)c*") : null;
        // Variant 4: Equivalent regex with explicit finite quantifier
        Pattern p4 = Pattern.compile("(ab){0,}");
    }
}