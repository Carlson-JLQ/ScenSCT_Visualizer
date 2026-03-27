// A regular expression term compiled in VERBOSE mode (using Pattern.COMMENTS) that does not exhibit exponential backtracking behavior should not be flagged.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase2_Var2 {
    // Helper method to compile a safe verbose pattern
    private static Pattern compileVerbose(String regex) {
        return Pattern.compile(regex, Pattern.COMMENTS);
    }

    public static void main(String[] args) {
        // Variant 2: Inter-procedural refactoring - extraction to helper
        Pattern p = compileVerbose(
            "abc        # literal abc\n" +
            "\\d{2,4}   # two to four digits"
        );
        // Inline with variable for regex part
        String spaces = " {3}";
        Pattern p2 = Pattern.compile(
            "a" + spaces + "  # exactly three spaces after a",
            Pattern.COMMENTS
        );
    }
}