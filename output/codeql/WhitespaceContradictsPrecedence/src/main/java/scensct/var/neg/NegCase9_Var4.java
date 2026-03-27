// A binary expression inner is not a direct child operand of outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase9_Var4 {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4};
        int a = vals[0], b = vals[1], c = vals[2], d = vals[3];
        int r1 = a + b;
        int r2 = c + d;
        int result = r1 * r2; // '*' operands are sums, but each '+' is in its own subexpression
        System.out.println(result);
    }
}