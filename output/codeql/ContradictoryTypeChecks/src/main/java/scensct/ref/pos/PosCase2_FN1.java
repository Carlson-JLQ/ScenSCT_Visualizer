// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is checked with instanceof for a subtype of that supertype should be flagged as contradictory type check.
package scensct.ref.pos;

public class PosCase2_FN1 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Guard checks if obj is a supertype (String)
        if (obj instanceof String) {
            // True path: safe
            String s = (String) obj;
        } else {
            // False path: obj is NOT a String, but checked for a subtype (Integer) of Object
            if (obj instanceof Integer) { // Contradictory: cannot be Integer if not String (both subtypes of Object)
                Integer i = (Integer) obj;
            }
        }
    }
}