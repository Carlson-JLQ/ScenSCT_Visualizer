// Binary expression that is a redundant equality test (guarded) used within an assertion should not be flagged as always true/false.
package scensct.ref.neg;

public class NegCase4_FP1 {
    public static void main(String[] args) {
        int x = 10;
        // Guard equality test
        if (x == 10) { // [REPORTED LINE]
            // Redundant equality test inside assertion (excluded by checker)
            assert x == 10 : "x should be 10";
        }
    }
}