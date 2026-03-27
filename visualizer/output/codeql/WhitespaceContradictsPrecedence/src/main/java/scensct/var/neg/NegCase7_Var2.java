// A binary expression inner directly nested inside outer, inner not parenthesized, and no whitespace around inner operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase7_Var2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 2;
        int result = a + b * c;
        System.out.println(result);
    }
}