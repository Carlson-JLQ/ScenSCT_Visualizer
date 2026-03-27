// Binary expression that is a redundant equality test (guarded) used within an assertion should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        int x = getValue();
        // Guard inside a loop that runs once
        for (int i = 0; i < 1; i++) {
            if (x == 10) {
                // Move assertion into a helper method
                verifyEquality(x);
            }
        }
    }
    private static int getValue() {
        return 10;
    }
    private static void verifyEquality(int v) {
        assert v == 10 : "v should be 10";
    }
}