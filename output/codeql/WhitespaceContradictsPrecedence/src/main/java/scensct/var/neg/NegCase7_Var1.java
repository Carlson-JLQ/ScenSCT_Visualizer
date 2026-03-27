// A binary expression inner directly nested inside outer, inner not parenthesized, and no whitespace around inner operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int res = x + y * z;
        System.out.println(res);
    }
}