// A binary expression inner is not a direct child operand of outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase9 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        int result = a + b * (c + d); // inner '*' is directly nested inside '+', but inner '+' is nested inside parentheses, not directly under outer '+'
        // Actually to satisfy: inner not directly nested inside outer - use separate statements
        int r1 = a + b;
        int r2 = r1 * c; // '*' is not directly nested inside '+' from previous line
        System.out.println(r2);
    }
}