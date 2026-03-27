// Hard-coded regex pattern should not be flagged as regex injection.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Pattern from a hard-coded literal, not user-provided.
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^\\d+$");
        System.out.println(pattern.matcher("123").matches());
    }
}