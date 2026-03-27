// A variable is checked with instanceof for a supertype in a guard condition, and on the guard's false path, the same variable is cast to a subtype of that supertype should be flagged as contradictory type check.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        Object obj = new Object();
        // Use a ternary operator to choose a path, but keep the cast in the false branch
        Runnable action = (obj instanceof CharSequence) 
            ? () -> { CharSequence cs = (CharSequence) obj; }
            : () -> { String s = (String) obj; }; // Contradictory cast inside lambda
        action.run();
    }
}