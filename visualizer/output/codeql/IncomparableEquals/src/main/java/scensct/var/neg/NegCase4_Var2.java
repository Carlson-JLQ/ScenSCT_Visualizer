// A Java source file containing a call to equals(Object) nested inside a method call whose name begins with "assert" should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase4_Var2 {
    static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new RuntimeException("Assertion failed");
    }
    
    static void assertTrue(boolean condition) {
        if (!condition) throw new RuntimeException("Assertion failed");
    }
    
    // Helper that still calls assert method
    static void checkEquality(Object a, Object b) {
        assertTrue(a.equals(b));
    }
    
    public static void main(String[] args) {
        // Variant 2: equals passed via helper, still inside assertTrue
        StringBuilder sb = new StringBuilder("abc");
        Thread t = new Thread();
        checkEquality(sb, t);
    }
}