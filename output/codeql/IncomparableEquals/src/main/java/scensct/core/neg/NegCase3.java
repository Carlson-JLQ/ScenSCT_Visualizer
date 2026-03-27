// A Java source file containing a call to equals(Object) where the call is the expression inside an assert statement should not be flagged as incomparable equals.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        Object obj = "hello";
        Object other = "world";
        // The equals call is inside an assert statement.
        assert obj.equals(other);
    }
}