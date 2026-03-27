// A binary expression inner directly nested inside outer, inner not parenthesized, and no whitespace around inner operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase7_Var4 {
    public static void main(String[] args) {
        int val = 100;
        if (val > 0) {
            int a = 1, b = 2, c = 3;
            int result = a + b * c;
            System.out.println(result);
        }
    }
}