// A regular expression term compiled in VERBOSE mode (using Pattern.COMMENTS) that does not exhibit exponential backtracking behavior should not be flagged.
package scensct.core.neg;

import java.util.regex.Pattern;

public class NegCase2 {
    public static void main(String[] args) {
        // VERBOSE mode with whitespace and comments, but pattern is inherently safe (no exponential backtracking)
        Pattern p = Pattern.compile(
            "abc        # literal abc\n" +
            "\\d{2,4}   # two to four digits",
            Pattern.COMMENTS
        );
        // Another safe pattern in VERBOSE mode: finite repetition only
        Pattern p2 = Pattern.compile(
            "a {3}  # exactly three spaces after a",
            Pattern.COMMENTS
        );
    }
}