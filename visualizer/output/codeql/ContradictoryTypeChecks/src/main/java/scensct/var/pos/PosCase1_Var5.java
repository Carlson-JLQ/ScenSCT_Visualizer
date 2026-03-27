// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is cast to a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase1_Var5 {
    // Extract the contradictory check into a helper method
    private static void process(Object obj) {
        if (obj instanceof CharSequence) {
            CharSequence cs = (CharSequence) obj;
        } else {
            String s = (String) obj; // Contradictory cast // [REPORTED LINE]
        }
    }
    
    public static void main(String[] args) {
        Object obj = new Object();
        process(obj);
    }
}