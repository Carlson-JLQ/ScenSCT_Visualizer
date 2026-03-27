// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is checked with instanceof for a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Wrap the guard in a try-catch-finally, but keep the logic intact
        try {
            if (obj instanceof CharSequence) {
                CharSequence cs = (CharSequence) obj;
            } else {
                if (obj instanceof String) { // [REPORTED LINE]
                    String s = (String) obj; // [REPORTED LINE]
                }
            }
        } finally {
            // Some unrelated cleanup; does not affect the type flow
            System.gc();
        }
    }
}