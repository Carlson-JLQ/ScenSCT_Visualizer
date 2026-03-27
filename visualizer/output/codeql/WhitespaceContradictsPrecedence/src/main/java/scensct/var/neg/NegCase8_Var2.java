// A binary expression inner directly nested inside outer, inner not parenthesized, whitespace around inner operator is even, and no whitespace around outer operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase8_Var2 {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3};
        int result = vals[0]+vals[1]*vals[2]; // Using array accesses, same operator spacing
        System.out.println(result);
    }
}