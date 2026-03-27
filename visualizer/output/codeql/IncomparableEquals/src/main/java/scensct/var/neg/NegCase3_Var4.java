// A Java source file containing a call to equals(Object) where the call is the expression inside an assert statement should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        Object obj = "hello";
        Object other = "world";
        // Place the assert inside a loop that runs at most once
        for (int i = 0; i < 1; i++) {
            assert obj.equals(other);
        }
    }
}