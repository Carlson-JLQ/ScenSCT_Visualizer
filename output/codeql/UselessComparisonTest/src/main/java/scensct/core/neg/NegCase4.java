// Binary expression that is a redundant equality test (guarded) used within an assertion should not be flagged as always true/false.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        int x = getValue(); // Non-constant initialization
        // Guard equality test
        if (x == 10) {
            // Redundant equality test inside assertion (excluded by checker)
            assert x == 10 : "x should be 10";
        }
    }
    private static int getValue() {
        return 10; // Still returns 10, but breaks constant propagation
    }
}