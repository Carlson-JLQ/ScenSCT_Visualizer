// A division expression as left operand of remainder, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase5 {
    public static void main(String[] args) {
        int x = 10, a = 20, b = 3, c = 2;
        int result = x + a / b % c; // inner '/' is left operand of '%', nested directly inside '+'
        System.out.println(result);
    }
}