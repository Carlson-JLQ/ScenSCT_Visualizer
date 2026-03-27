// Equality test where guard compares v with constant c1, but test does not compare v with any constant, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        int v = fetchValue();
        int w = fetchOther();
        // Guard inside a try-catch block (no exception thrown)
        try {
            if (v == 5) {
                System.out.println("Guard");
            }
        } catch (Exception e) {
            // ignored
        }
        // Test: v == w after the try-catch
        if (v == w) {
            System.out.println("Test");
        }
    }
    private static int fetchValue() {
        return 5;
    }
    private static int fetchOther() {
        return 7;
    }
}