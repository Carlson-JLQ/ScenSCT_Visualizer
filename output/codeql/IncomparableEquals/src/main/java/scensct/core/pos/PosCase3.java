// Nested call to Object.equals with incomparable types should be flagged as positive.
package scensct.core.pos;

public class PosCase3 {
    static void someMethod(boolean b) {
        // Dummy method to nest the equals call
    }
    public static void main(String[] args) {
        // Receiver type StringBuilder, argument type Thread, no common subtype except Object
        StringBuilder sb = new StringBuilder();
        Thread t = new Thread();
        // Nested inside method call (someMethod) whose name does not start with "assert"
        someMethod(sb.equals(t)); // Should trigger report // [REPORTED LINE]
    }
}