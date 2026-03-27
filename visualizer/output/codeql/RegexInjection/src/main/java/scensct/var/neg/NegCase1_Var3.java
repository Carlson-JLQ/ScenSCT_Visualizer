// Hard-coded regex pattern should not be flagged as regex injection.
package scensct.var.neg;

public class NegCase1_Var3 {
    private static java.util.regex.Pattern buildPattern() {
        return java.util.regex.Pattern.compile("^\\d+$");
    }

    public static void main(String[] args) {
        java.util.regex.Pattern pattern = buildPattern();
        System.out.println(pattern.matcher("123").matches());
    }
}