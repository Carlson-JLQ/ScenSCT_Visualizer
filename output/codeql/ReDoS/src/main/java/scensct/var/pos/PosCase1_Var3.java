// A Java source file containing a regular expression (not in verbose mode) with a term (e.g., nested quantifiers like (a+)+ or ambiguous alternations inside a repetition) that, when matched against a specific input string, triggers exponential backtracking (ReDoS) should be flagged as Positive.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Lexical refactoring with equivalent expression and control flow
        String pat = "(a+)+"; // [REPORTED LINE]
        String str = new StringBuilder()
            .append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            .append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            .append("aaaaaaaaaaaaaaaaaaaaaaaa")
            .toString();
        
        if (str != null) {
            boolean ok = str.matches(pat);
            System.out.println(ok);
        }
    }
}