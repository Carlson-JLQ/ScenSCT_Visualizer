// Binary expression that is a redundant equality test (guarded) used within an assertion should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        int x = getValue();
        // Guard with method call that returns boolean
        if (isTen(x)) {
            // Assertion inside try-catch (still reachable)
            try {
                assert x == 10 : "x mismatch";
            } catch (AssertionError e) {
                throw e;
            }
        }
    }
    private static int getValue() {
        return 10;
    }
    private static boolean isTen(int n) {
        return n == 10;
    }
}