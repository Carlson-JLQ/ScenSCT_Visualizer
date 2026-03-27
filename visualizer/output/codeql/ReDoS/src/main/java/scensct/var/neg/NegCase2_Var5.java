// A regular expression term compiled in VERBOSE mode (using Pattern.COMMENTS) that does not exhibit exponential backtracking behavior should not be flagged.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase2_Var5 {
    // Constants for regex parts
    private static final String ABC_PART = "abc        # literal abc\n";
    private static final String DIGIT_PART = "\\d{2,4}   # two to four digits";

    public static void main(String[] args) {
        // Variant 5: Lexical + inter-procedural - constants and flag combination
        int flags = Pattern.COMMENTS;
        Pattern p = Pattern.compile(ABC_PART + DIGIT_PART, flags);
        // Second pattern: using literal space count but with comment after newline
        Pattern p2 = Pattern.compile(
            "a {3}" + "\n" + "  # exactly three spaces after a",
            Pattern.COMMENTS
        );
    }
}