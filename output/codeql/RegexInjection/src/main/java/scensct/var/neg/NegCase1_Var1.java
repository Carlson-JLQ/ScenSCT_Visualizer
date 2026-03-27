// Hard-coded regex pattern should not be flagged as regex injection.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Same literal, but split and concatenated at compile time
        final String part1 = "^\\d";
        final String part2 = "+$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(part1 + part2);
        System.out.println(pattern.matcher("123").matches());
    }
}