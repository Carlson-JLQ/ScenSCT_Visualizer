// A binary expression inner is directly nested inside outer, inner is not parenthesized, and whitespace around inner operator is odd number of spaces should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result;
        if (args.length == 0) {
            result = a + b * c; // odd spaces around '*'
        } else {
            result = 0;
        }
        System.out.println(result);
    }
}