// Equality test where guard compares v with constant c1, but test does not compare v with any constant, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        int v = getV();
        int w = getW();
        // Guard restructured as a ternary that does not affect flow
        String msg = (v == 5) ? "Guard" : null;
        if (msg != null) {
            System.out.println(msg);
        }
        // Test: v == w, unchanged
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