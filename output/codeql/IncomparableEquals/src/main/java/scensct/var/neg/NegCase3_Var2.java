// A Java source file containing a call to equals(Object) where the call is the expression inside an assert statement should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        Object obj = "hello";
        Object other = "world";
        // Introduce a temporary variable for the equals result
        boolean eq = obj.equals(other);
        assert eq;
    }
}