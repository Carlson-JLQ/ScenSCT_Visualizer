// Binary expression that is a redundant equality test (guarded) used within an assertion should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        // Inline getValue logic but still non-constant due to method call
        int y = compute();
        // Guard with reversed condition logic
        boolean notTen = y != 10;
        if (!notTen) {
            // Assert with literal on left side
            assert 10 == y : "10 expected";
        }
    }
    private static int compute() {
        return getValue();
    }
    private static int getValue() {
        return 10;
    }
}