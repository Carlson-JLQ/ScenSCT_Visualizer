// A binary expression inner directly nested inside outer, inner not parenthesized, whitespace around inner operator is even, and no whitespace around outer operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase8_Var1 {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int computed = x+y*z; // Same pattern: inner '*' even spaces (0), outer '+' no spaces
        System.out.println(computed);
    }
}