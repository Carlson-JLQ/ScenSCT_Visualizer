// Hard-coded regex pattern should not be flagged as regex injection.
package scensct.var.neg;

public class NegCase1_Var4 {
    private static final String REGEX = "^\\d+$";

    public static void main(String[] args) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(REGEX);
        System.out.println(pattern.matcher("123").matches());
    }
}