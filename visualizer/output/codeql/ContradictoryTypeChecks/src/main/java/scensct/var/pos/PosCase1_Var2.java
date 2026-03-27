// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is cast to a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Restructure control flow: use early return on true branch
        if (obj instanceof CharSequence) {
            CharSequence cs = (CharSequence) obj;
            return;
        }
        // After early return, this is effectively the false branch
        String s = (String) obj; // Contradictory cast // [REPORTED LINE]
    }
}