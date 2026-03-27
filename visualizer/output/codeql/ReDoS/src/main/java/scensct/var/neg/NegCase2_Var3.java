// A regular expression term compiled in VERBOSE mode (using Pattern.COMMENTS) that does not exhibit exponential backtracking behavior should not be flagged.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Intra-procedural control flow - pattern compilation inside a block with temporary variable
        final Pattern p;
        {
            String regex = "abc        # literal abc\n" +
                           "\\d{2,4}   # two to four digits";
            p = Pattern.compile(regex, Pattern.COMMENTS);
        }
        // Second pattern: use try-catch for unrelated reason (stress flow analysis)
        Pattern p2 = null;
        try {
            p2 = Pattern.compile(
                "a {3}  # exactly three spaces after a",
                Pattern.COMMENTS
            );
        } catch (Exception e) {
            // ignore, won't happen
        }
    }
}