// Nested call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase3_Var3 {
    // Inline the dummy method's logic (trivial) and rename
    static void checkCondition(boolean cond) {
        // Empty, just to nest
    }
    public static void main(String[] args) {
        // Use different variable names and a final modifier
        final StringBuilder receiver = new StringBuilder();
        Thread other = new Thread();
        // Nested call with renamed method
        checkCondition(receiver.equals(other)); // [REPORTED LINE]
    }
}