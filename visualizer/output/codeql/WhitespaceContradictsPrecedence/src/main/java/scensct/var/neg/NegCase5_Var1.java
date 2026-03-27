// A division expression as left operand of remainder, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        int val = 10, p = 20, q = 3, r = 2;
        int res = val + p / q % r; // same structure, renamed identifiers
        System.out.println(res);
    }
}