// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is cast to a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        Object thing = new Object();
        // Use a temporary variable to hold the result of instanceof
        boolean isCharSeq = thing instanceof CharSequence;
        if (isCharSeq) {
            CharSequence cs = (CharSequence) thing;
        } else {
            // Still contradictory: cannot be String if not CharSequence
            String s = (String) thing; // [REPORTED LINE]
        }
    }
}