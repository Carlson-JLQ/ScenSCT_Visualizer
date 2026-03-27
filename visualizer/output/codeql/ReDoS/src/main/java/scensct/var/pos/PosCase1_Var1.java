// A Java source file containing a regular expression (not in verbose mode) with a term (e.g., nested quantifiers like (a+)+ or ambiguous alternations inside a repetition) that, when matched against a specific input string, triggers exponential backtracking (ReDoS) should be flagged as Positive.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Extract pattern to a constant and use Pattern.compile
        final String regex = "(a+)+"; // [REPORTED LINE]
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        String testInput = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        boolean result = p.matcher(testInput).matches();
        System.out.println(result);
    }
}