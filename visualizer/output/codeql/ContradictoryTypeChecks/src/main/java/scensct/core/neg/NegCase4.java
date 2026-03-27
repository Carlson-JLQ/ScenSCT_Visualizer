// Variable checked via instanceof for SUP, but later cast uses different expression than the variable access should not be flagged as contradictory type check.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        Object obj1 = "test";
        Object obj2 = new StringBuilder();
        // Instanceof check for supertype CharSequence (SUP) on obj1
        if (obj1 instanceof CharSequence) {
            // Later cast to subtype StringBuilder (T) on different expression obj2
            StringBuilder sb = (StringBuilder) obj2; // No contradiction: different variable access
        }
    }
}