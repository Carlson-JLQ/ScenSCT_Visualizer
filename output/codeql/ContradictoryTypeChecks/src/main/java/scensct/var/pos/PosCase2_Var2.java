// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is checked with instanceof for a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Restructure control flow: use a boolean flag derived from the guard
        boolean isCharSeq = obj instanceof CharSequence;
        if (isCharSeq) {
            CharSequence cs = (CharSequence) obj;
        } else {
            // The contradictory check remains in the else block
            if (obj instanceof String) { // [REPORTED LINE]
                String s = (String) obj; // [REPORTED LINE]
            }
        }
    }
}