// A Java source file containing a call to equals(Object) where the compile-time types share a common subtype other than Object should not be flagged as incomparable equals.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        String s = "a";
        Object o = "b"; // Both s and o have a common subtype String.
        boolean result = s.equals(o); // Common subtype exists, so not incomparable.
        System.out.println(result);
    }
}