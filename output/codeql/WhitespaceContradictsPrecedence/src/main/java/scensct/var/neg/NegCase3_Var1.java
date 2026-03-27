// A multiplication expression as left operand of division, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        int val = 10, p = 2, q = 3, r = 4;
        int res = val + p * q / r; // same whitespace, renamed identifiers
        System.out.println(res);
    }
}