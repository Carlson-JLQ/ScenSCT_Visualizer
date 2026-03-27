// A binary expression inner directly nested inside outer, inner not parenthesized, and no whitespace around inner operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase7_Var5 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = compute(a, b, c);
        System.out.println(result);
    }

    private static int compute(int x, int y, int z) {
        return x + y * z;
    }
}