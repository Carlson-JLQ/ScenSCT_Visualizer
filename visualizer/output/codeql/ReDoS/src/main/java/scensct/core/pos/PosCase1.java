// A Java source file containing a regular expression (not in verbose mode) with a term (e.g., nested quantifiers like (a+)+ or ambiguous alternations inside a repetition) that, when matched against a specific input string, triggers exponential backtracking (ReDoS) should be flagged as Positive.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        // Nested quantifiers pattern: (a+)+ is a classic ReDoS pattern
        String pattern = "(a+)+"; // [REPORTED LINE]
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        
        // Matching the pattern against a long string of 'a's triggers exponential backtracking
        boolean matches = input.matches(pattern);
        System.out.println(matches);
    }
}