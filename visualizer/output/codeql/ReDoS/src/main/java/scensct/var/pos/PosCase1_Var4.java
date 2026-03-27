// A Java source file containing a regular expression (not in verbose mode) with a term (e.g., nested quantifiers like (a+)+ or ambiguous alternations inside a repetition) that, when matched against a specific input string, triggers exponential backtracking (ReDoS) should be flagged as Positive.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Introduce a temporary variable and use try-catch
        final String re = "(a+)+"; // [REPORTED LINE]
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        try {
            boolean match = java.util.regex.Pattern.matches(re, input);
            System.out.println(match);
        } catch (Exception e) {
            // ignore
        }
    }
}