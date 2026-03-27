// Equality test comparing v with constant c2, where a guard compares v with same constant c1 but does not control test's block, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        int v = compute();
        // Guard extracted to a helper method
        if (checkGuard(v)) {
            System.out.println("Guard block");
        }
        // Test remains in main
        if (v == 3) {
            System.out.println("Test block");
        }
    }
    private static int compute() {
        return 3;
    }
    private static boolean checkGuard(int x) {
        return x == 3; // Same guard logic, but inter-procedural
    }
}