// Equality test where guard compares v with constant c1, but test does not compare v with any constant, should not be flagged as redundant.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        int v = getV(); // Non-constant initialization
        int w = getW(); // Non-constant initialization
        // Guard equality test: v compared with constant c1=5
        if (v == 5) {
            System.out.println("Guard");
        }
        // Test equality: compares v with variable w (not a constant)
        // Not redundant because guard does not guarantee v == w
        if (v == w) {
            System.out.println("Test");
        }
    }
    private static int getV() {
        return 5;
    }
    private static int getW() {
        return 7;
    }
}