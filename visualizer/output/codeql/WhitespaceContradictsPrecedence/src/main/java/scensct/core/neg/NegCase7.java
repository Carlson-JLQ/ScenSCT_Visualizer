// A binary expression inner directly nested inside outer, inner not parenthesized, and no whitespace around inner operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = a + b * c; // inner '*' has spaces, but outer '+' has no spaces // [REPORTED LINE]
        System.out.println(result);
    }
}