// A Java source file containing a regular expression (not in verbose mode) with a term (e.g., nested quantifiers like (a+)+ or ambiguous alternations inside a repetition) that, when matched against a specific input string, triggers exponential backtracking (ReDoS) should be flagged as Positive.
package scensct.var.pos;

public class PosCase1_Var2 {
    private static String getPattern() {
        return "(a+)+"; // [REPORTED LINE]
    }
    
    private static boolean checkInput(String input) {
        return input.matches(getPattern());
    }
    
    public static void main(String[] args) {
        // Variant 2: Inter-procedural extraction
        String data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        boolean matches = checkInput(data);
        System.out.println(matches);
    }
}