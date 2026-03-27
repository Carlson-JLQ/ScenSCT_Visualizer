// Equality test where guard compares v with constant c1, but test does not compare v with any constant, should not be flagged as redundant.
package scensct.ref.neg;

public class NegCase3_FP1 {
    public static void main(String[] args) {
        int v = 5;
        int w = 7;
        // Guard equality test: v compared with constant c1=5
        if (v == 5) { // [REPORTED LINE]
            System.out.println("Guard");
        }
        // Test equality: compares v with variable w (not a constant)
        // Not redundant because guard does not guarantee v == w
        if (v == w) { // [REPORTED LINE]
            System.out.println("Test");
        }
    }
}