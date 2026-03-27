// A binary expression inner directly nested inside outer, inner not parenthesized, whitespace around inner operator is even, and no whitespace around outer operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase8 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = a+b*c; // inner '*' has one space each side (odd), but scenario requires even (0 spaces) - adjusted to 0 spaces // [REPORTED LINE]
        // Actually for even spaces (0 spaces) and outer has no spaces: a+b*c
        int result2 = a+b*c; // inner '*' has 0 spaces (even), outer '+' has no spaces
        System.out.println(result2);
    }
}