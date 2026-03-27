// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is checked with instanceof for a subtype of that supertype should be flagged as contradictory type check.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Guard checks if obj is a supertype (CharSequence)
        if (obj instanceof CharSequence) {
            // True path: safe
            CharSequence cs = (CharSequence) obj;
        } else {
            // False path: obj is NOT a CharSequence, but checked for a subtype (String) of CharSequence
            if (obj instanceof String) { // Contradictory: cannot be String if not CharSequence // [REPORTED LINE]
                String s = (String) obj; // [REPORTED LINE]
            }
        }
    }
}