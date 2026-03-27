// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is checked with instanceof for a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Use a different but equivalent supertype-subtype pair from java.lang
        // Number is supertype of Integer
        if (obj instanceof Number) {
            Number n = (Number) obj;
        } else {
            // Contradictory: cannot be Integer if not Number
            if (obj instanceof Integer) { // [REPORTED LINE]
                Integer i = (Integer) obj; // [REPORTED LINE]
            }
        }
    }
}