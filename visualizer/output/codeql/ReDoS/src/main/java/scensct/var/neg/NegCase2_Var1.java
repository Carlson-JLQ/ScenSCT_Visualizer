// A regular expression term compiled in VERBOSE mode (using Pattern.COMMENTS) that does not exhibit exponential backtracking behavior should not be flagged.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - regex split across more lines, extra comments, and flag via variable
        int verboseFlag = Pattern.COMMENTS;
        Pattern p = Pattern.compile(
            "abc          # literal abc\n" +
            "             # blank line comment\n" +
            "\\d{2,4}     # two to four digits\n" +
            "# end of pattern",
            verboseFlag
        );
        // Second pattern: use escaped spaces and different comment style
        Pattern p2 = Pattern.compile(
            "a\\ \\ \\    # exactly three spaces after a (escaped)",
            Pattern.COMMENTS
        );
    }
}