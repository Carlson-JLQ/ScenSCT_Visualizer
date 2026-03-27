// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is checked with instanceof for a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Introduce a temporary variable to alias the original
        Object temp = obj;
        // Guard condition on the alias
        if (temp instanceof CharSequence) {
            CharSequence cs = (CharSequence) temp;
        } else {
            // The false branch still refers to the original variable
            if (obj instanceof String) {
                String s = (String) obj;
            }
        }
    }
}