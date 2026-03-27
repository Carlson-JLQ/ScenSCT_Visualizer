// Variable checked via instanceof for SUP, later cast on false edge (not guarded by instanceof failure) should not be flagged as contradictory type check.
package scensct.ref.neg;

public class NegCase5_FP1 {
    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for supertype CharSequence (SUP)
        if (!(obj instanceof CharSequence)) {
            // Cast to subtype StringBuilder (T) occurs only when instanceof is false
            StringBuilder sb = (StringBuilder) obj; // No contradiction: cast not executed when instanceof true // [REPORTED LINE]
        }
    }
}