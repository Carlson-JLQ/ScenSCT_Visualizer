// A binary equality expression directly nested inside another binary equality expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        boolean a = true, b = false, c = true;
        boolean result = a == b == c; // inner '==' nested directly inside outer '=='
        System.out.println(result);
    }
}