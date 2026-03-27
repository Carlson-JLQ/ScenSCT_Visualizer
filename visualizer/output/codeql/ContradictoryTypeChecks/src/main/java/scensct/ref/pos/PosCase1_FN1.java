// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is cast to a subtype of that supertype should be flagged as contradictory type check.
package scensct.ref.pos;

public class PosCase1_FN1 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Guard checks if obj is a supertype (String)
        if (obj instanceof String) {
            // True path: safe to treat as String
            String s = (String) obj;
        } else {
            // False path: obj is NOT a String, but cast to a subtype (Integer) of Object
            Integer i = (Integer) obj; // Contradictory: cannot be Integer if not String (both subtypes of Object)
        }
    }
}