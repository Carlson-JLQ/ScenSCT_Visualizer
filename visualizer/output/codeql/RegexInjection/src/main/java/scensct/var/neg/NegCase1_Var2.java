// Hard-coded regex pattern should not be flagged as regex injection.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        String regex = "^\\d+$";
        java.util.regex.Pattern p = null;
        // Irrelevant branching that does not affect the constant
        if (System.currentTimeMillis() > 0) {
            p = java.util.regex.Pattern.compile(regex);
        } else {
            p = java.util.regex.Pattern.compile("^\\d+$");
        }
        System.out.println(p.matcher("123").matches());
    }
}