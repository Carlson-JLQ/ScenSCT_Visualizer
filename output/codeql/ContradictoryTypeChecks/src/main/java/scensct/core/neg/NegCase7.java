// Variable checked via instanceof for SUP, SSA definition read but not used in cast/instanceof should not be flagged as contradictory type check.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for supertype CharSequence (SUP)
        if (obj instanceof CharSequence) {
            // Read SSA definition from obj, but use it in non-cast expression
            int length = ((CharSequence) obj).length(); // Read used, but not for subtype T cast/instanceof
        }
    }
}