// A binary expression inner is directly nested inside outer, inner is not parenthesized, and whitespace around inner operator is odd number of spaces should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase1_Var3 {
    static int compute(int p, int q, int r) {
        return p + q * r; // inner '*' with odd spaces
    }
    public static void main(String[] args) {
        int res = compute(1, 2, 3);
        System.out.println(res);
    }
}