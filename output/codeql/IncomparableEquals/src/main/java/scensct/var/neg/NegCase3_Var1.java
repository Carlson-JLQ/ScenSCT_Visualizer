// A Java source file containing a call to equals(Object) where the call is the expression inside an assert statement should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        Object obj = "hello";
        Object other = "world";
        // Wrap in parentheses and add a trivial boolean context
        assert (obj.equals(other) == true);
    }
}