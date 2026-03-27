// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is cast to a subtype of that supertype should be flagged as contradictory type check.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Guard checks if obj is a supertype (CharSequence)
        if (obj instanceof CharSequence) {
            // True path: safe to treat as CharSequence
            CharSequence cs = (CharSequence) obj;
        } else {
            // False path: obj is NOT a CharSequence, but cast to a subtype (String) of CharSequence
            String s = (String) obj; // Contradictory: cannot be String if not CharSequence // [REPORTED LINE]
        }
    }
}