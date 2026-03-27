// Nested call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase3_Var5 {
    static void someMethod(boolean b) {
        // Dummy method
    }
    public static void main(String[] args) {
        // Introduce a trivial if-else that does not affect reachability
        StringBuilder sb = new StringBuilder();
        Thread t = new Thread();
        if (args.length >= 0) { // Always true
            // Nested call inside a branch
            someMethod(sb.equals(t)); // [REPORTED LINE]
        } else {
            // Dead code, not executed
        }
    }
}