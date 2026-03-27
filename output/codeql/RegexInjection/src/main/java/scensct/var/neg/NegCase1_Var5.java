// Hard-coded regex pattern should not be flagged as regex injection.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        java.util.regex.Pattern pattern = null;
        try {
            pattern = java.util.regex.Pattern.compile("^\\d+$");
        } finally {
            // Irrelevant cleanup; pattern already assigned
        }
        System.out.println(pattern.matcher("123").matches());
    }
}