// Variable checked for supertype SUP, later cast to unrelated type T (not subtype of SUP) should not be flagged as contradictory type check.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for supertype CharSequence (SUP)
        if (obj instanceof CharSequence) {
            // Later cast to unrelated type Integer (T), not a subtype of CharSequence
            Integer i = (Integer) obj; // No contradiction: T is not a subtype of SUP
        }
    }
}