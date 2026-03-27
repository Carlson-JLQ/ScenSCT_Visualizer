// A Java source file containing a call to equals(Object) nested inside a method call whose name begins with "assert" should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase4_Var3 {
    static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new RuntimeException("Assertion failed");
    }
    
    static void assertTrue(boolean condition) {
        if (!condition) throw new RuntimeException("Assertion failed");
    }
    
    public static void main(String[] args) {
        // Variant 3: equals in conditional branch, still argument to assert
        Object a = "hello";
        Object b = 123;
        boolean result;
        if (args.length > 0) {
            result = a.equals(b);
        } else {
            result = b.equals(a);
        }
        assertTrue(result);
    }
}