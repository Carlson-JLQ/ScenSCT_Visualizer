// Equality test where guard compares v with constant c1, but test does not compare v with any constant, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        int x = getV();
        int y = getW();
        // Guard: x compared with constant 5
        if (x == 5) {
            System.out.println("Guard");
        }
        // Test: x compared with y (non-constant)
        boolean result = (x == y);
        if (result) {
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