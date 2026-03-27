// Binary expression that is a redundant equality test (guarded) used within an assertion should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        int val = getValue();
        // Guard with early return instead of if-block
        if (val != 10) return;
        // Assertion with same equality, but using a temporary variable
        int target = 10;
        assert val == target : "val should be 10";
    }
    private static int getValue() {
        return 10;
    }
}