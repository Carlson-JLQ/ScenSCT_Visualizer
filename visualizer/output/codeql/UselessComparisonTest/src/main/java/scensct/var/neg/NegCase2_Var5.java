// Equality test comparing v with constant c2, where a guard compares v with same constant c1 but does not control test's block, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        int v = compute();
        // Guard inside a loop that executes exactly once
        for (int i = 0; i < 1; i++) {
            if (v == 3) {
                System.out.println("Guard in loop");
            }
        }
        // Test after loop, separate block
        if (v == 3) {
            System.out.println("Test after loop");
        }
    }
    private static int compute() {
        return 3;
    }
}