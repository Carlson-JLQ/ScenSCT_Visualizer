// A Java source file containing a call to equals(Object) where the call is the expression inside an assert statement should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        Object obj = "hello";
        Object other = "world";
        // Extract the assert into a private static helper
        checkEquals(obj, other);
    }
    
    private static void checkEquals(Object a, Object b) {
        assert a.equals(b);
    }
}