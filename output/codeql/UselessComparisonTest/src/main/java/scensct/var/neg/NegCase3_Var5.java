// Equality test where guard compares v with constant c1, but test does not compare v with any constant, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        int v = getV();
        int w = getW();
        // Guard extracted to a helper method
        checkGuard(v);
        // Test: v == w remains in main
        if (v == w) {
            System.out.println("Test");
        }
    }
    private static void checkGuard(int value) {
        if (value == 5) {
            System.out.println("Guard");
        }
    }
    private static int getV() {
        return 5;
    }
    private static int getW() {
        return 7;
    }
}