// A binary expression inner is directly nested inside outer, inner is not parenthesized, and whitespace around inner operator is odd number of spaces should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = a + b * c; // inner '*' has one space on each side (odd), nested directly inside '+'
        System.out.println(result);
    }
}