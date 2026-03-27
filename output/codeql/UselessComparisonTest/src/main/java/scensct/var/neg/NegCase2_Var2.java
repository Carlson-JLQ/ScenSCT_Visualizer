// Equality test comparing v with constant c2, where a guard compares v with same constant c1 but does not control test's block, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        int v = getValue(); // Different method name
        // Guard in a try block to alter control flow structure
        try {
            if (v == 3) {
                System.out.println("Inside guard");
            }
        } finally {
            // Empty finally, no modification
        }
        // Separate block for test
        if (v == 3) {
            System.out.println("Test here");
        }
    }
    private static int getValue() {
        return 3;
    }
}