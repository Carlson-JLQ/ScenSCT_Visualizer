// Equality test where guard compares v with constant c1, but test does not compare v with any constant, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        int v = getV();
        int w = getW();
        // Guard split into a loop that executes at most once
        for (int i = 0; i < 1; i++) {
            if (v == 5) {
                System.out.println("Guard");
                break;
            }
        }
        // Test: v == w after loop
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