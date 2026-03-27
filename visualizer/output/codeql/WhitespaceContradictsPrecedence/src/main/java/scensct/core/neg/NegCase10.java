// A binary expression of same operator kind directly nested inside another of same kind should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase10 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = a + b + c; // inner '+' nested directly inside outer '+' (same kind)
        System.out.println(result);
    }
}