// Nested call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase3_Var2 {
    static void someMethod(boolean b) {
        // Dummy method to nest the equals call
    }
    public static void main(String[] args) {
        // Split declaration and assignment, and use a temporary variable for the argument
        StringBuilder sb;
        sb = new StringBuilder();
        Thread threadArg = new Thread();
        // Nested call with temporary argument variable
        someMethod(sb.equals(threadArg)); // [REPORTED LINE]
    }
}