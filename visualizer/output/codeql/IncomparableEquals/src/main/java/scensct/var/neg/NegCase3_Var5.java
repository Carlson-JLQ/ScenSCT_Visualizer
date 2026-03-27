// A Java source file containing a call to equals(Object) where the call is the expression inside an assert statement should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        Object obj = "hello";
        Object other = "world";
        // Use a conditional that always passes, with assert on the then-branch
        if (obj != null) {
            assert obj.equals(other);
        }
    }
}