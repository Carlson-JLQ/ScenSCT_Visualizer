// A Java source file containing a regular expression (not in verbose mode) with a term (e.g., nested quantifiers like (a+)+ or ambiguous alternations inside a repetition) that, when matched against a specific input string, triggers exponential backtracking (ReDoS) should be flagged as Positive.
package scensct.var.pos;

public class PosCase1_Var5 {
    private static final String REGEX = "(a+)+"; // [REPORTED LINE]
    
    public static void main(String[] args) {
        // Variant 5: Static constant and loop (still one matching operation)
        String[] inputs = {
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        };
        for (String s : inputs) {
            if (s.matches(REGEX)) {
                System.out.println(true);
                break;
            }
        }
    }
}