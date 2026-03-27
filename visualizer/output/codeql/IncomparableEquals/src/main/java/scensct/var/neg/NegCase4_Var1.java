// A Java source file containing a call to equals(Object) nested inside a method call whose name begins with "assert" should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase4_Var1 {
    static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new RuntimeException("Assertion failed");
    }
    
    static void assertTrue(boolean condition) {
        if (!condition) throw new RuntimeException("Assertion failed");
    }
    
    public static void main(String[] args) {
        // Variant 1: Provably incomparable types, but inside assert method
        String s = "text";
        Integer i = 42;
        assertEquals(true, s.equals(i));
        assertTrue(s.equals(i));
    }
}