// A binary expression inner is directly nested inside outer, inner is not parenthesized, and whitespace around inner operator is odd number of spaces should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int inner = y * z; // still odd spaces around '*'
        int outer = x + inner;
        System.out.println(outer);
    }
}