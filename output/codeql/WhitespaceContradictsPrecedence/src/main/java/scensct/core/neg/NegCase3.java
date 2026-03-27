// A multiplication expression as left operand of division, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        int x = 10, a = 2, b = 3, c = 4;
        int result = x + a * b / c; // inner '*' is left operand of '/', nested directly inside '+'
        System.out.println(result);
    }
}