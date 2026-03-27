// A Java source file containing a call to equals(Object) nested inside a method call whose name begins with "assert" should not be flagged as incomparable equals.
package scensct.core.neg;

public class NegCase4 {
    // Helper method simulating an assertion method (e.g., from a test framework).
    static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new RuntimeException("Assertion failed");
    }
    
    static void assertTrue(boolean condition) {
        if (!condition) throw new RuntimeException("Assertion failed");
    }
    
    public static void main(String[] args) {
        Object x = "value";
        Object y = "other";
        // equals call nested inside a method whose name begins with "assert".
        assertEquals(true, x.equals(y));
        assertTrue(x.equals(y));
    }
}