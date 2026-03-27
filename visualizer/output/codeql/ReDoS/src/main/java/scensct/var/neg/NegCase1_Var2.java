// A regular expression term that does not contain ambiguous nested quantifiers or problematic alternations within an infinite repetition should not be flagged as causing exponential backtracking.
package scensct.var.neg;

import java.util.regex.Pattern;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Split pattern declarations across multiple lines with intermediate strings
        String base = "abc";
        Pattern p = Pattern.compile(base);

        // Use a temporary variable for repetition bounds
        int min = 3, max = 5;
        Pattern p2 = Pattern.compile("a{" + min + "," + max + "}");

        // Safe alternation with infinite repetition outside (c* is outside group)
        String altPart = "(a|b)";
        Pattern p3 = Pattern.compile(altPart + "c*");

        // Infinite repetition of a literal group, no inner quantifiers
        String group = "(ab)";
        Pattern p4 = Pattern.compile(group + "*");
    }
}