// Nested call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase3_Var4 {
    // Extract the equals call into a helper method that returns the boolean
    static boolean compareIncomparable(StringBuilder s, Thread t) {
        return s.equals(t); // [REPORTED LINE]
    }
    static void someMethod(boolean b) {
        // Dummy method
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Thread t = new Thread();
        // The equals call is now inside helper, but the nested call pattern is preserved
        someMethod(compareIncomparable(sb, t));
    }
}