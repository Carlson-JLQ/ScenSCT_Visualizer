// A regular expression term compiled in VERBOSE mode (using Pattern.COMMENTS) that does not exhibit exponential backtracking behavior should not be flagged.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - using Pattern.compile with multiline string simulation via array join
        String[] lines = {
            "abc        # literal abc",
            "\\d{2,4}   # two to four digits"
        };
        Pattern p = Pattern.compile(String.join("\n", lines), Pattern.COMMENTS);
        // Second pattern: using character array for spaces (still safe)
        char[] spaceChars = {' ', ' ', ' '};
        Pattern p2 = Pattern.compile(
            "a" + new String(spaceChars) + "  # exactly three spaces after a",
            Pattern.COMMENTS
        );
    }
}