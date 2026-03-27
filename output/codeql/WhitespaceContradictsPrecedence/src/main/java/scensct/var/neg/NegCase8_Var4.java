// A binary expression inner directly nested inside outer, inner not parenthesized, whitespace around inner operator is even, and no whitespace around outer operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase8_Var4 {
    private static int compute(int p, int q, int r) {
        return p+q*r; // Extracted to a helper method, same spacing
    }
    
    public static void main(String[] args) {
        int result = compute(1, 2, 3);
        System.out.println(result);
    }
}