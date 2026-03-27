// Equality test comparing v with constant c2, where a guard compares v with same constant c1 but does not control test's block, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        int value = compute(); // Renamed variable
        // Guard with same constant, but block is separate
        if (value == 3) {
            System.out.println("Guard executed");
        }
        // Test: same equality, but guard does not dominate this block
        boolean testResult = (value == 3); // Extracted to temporary
        if (testResult) {
            System.out.println("Test block");
        }
    }
    private static int compute() {
        return 3; // Non-constant from analysis perspective
    }
}