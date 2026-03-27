// A Java source file containing a call to equals(Object) nested inside a method call whose name begins with "assert" should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase4_Var4 {
    static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new RuntimeException("Assertion failed");
    }
    
    static void assertTrue(boolean condition) {
        if (!condition) throw new RuntimeException("Assertion failed");
    }
    
    // Different assert-like method name
    static void assertThat(boolean condition, String msg) {
        if (!condition) throw new RuntimeException(msg);
    }
    
    public static void main(String[] args) {
        // Variant 4: Using assertThat (still starts with "assert")
        String str = "test";
        Number num = 3.14;
        assertThat(str.equals(num), "Should be equal");
    }
}