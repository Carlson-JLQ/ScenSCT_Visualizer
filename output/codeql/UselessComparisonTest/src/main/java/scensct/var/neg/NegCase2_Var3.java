// Equality test comparing v with constant c2, where a guard compares v with same constant c1 but does not control test's block, should not be flagged as redundant.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        int v = compute();
        // Guard with reversed condition (negation) but same semantics
        if (!(v != 3)) { // Equivalent to v == 3
            System.out.println("Guard block");
        }
        // Test with same constant but different expression form
        if (3 == v) { // Swapped operands
            System.out.println("Test block");
        }
    }
    private static int compute() {
        return 3;
    }
}