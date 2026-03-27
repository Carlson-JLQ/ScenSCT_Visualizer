// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is cast to a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Wrap the check in a try-catch to add noise, but preserve logic
        try {
            if (obj instanceof CharSequence) {
                CharSequence cs = (CharSequence) obj;
            } else {
                throw new RuntimeException("Not a CharSequence");
            }
        } catch (RuntimeException e) {
            // This corresponds to the false branch
            String s = (String) obj; // Contradictory cast // [REPORTED LINE]
        }
    }
}