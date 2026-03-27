// Equality test comparing v with constant c2, where a guard compares v with same constant c1 but does not control test's block, should not be flagged as redundant.
package scensct.ref.neg;

public class NegCase2_FP1 {
    public static void main(String[] args) {
        int v = 3;
        // Guard equality test with constant c1=3
        if (v == 3) { // [REPORTED LINE]
            System.out.println("Guard block");
        }
        // Test equality with same constant c2=3, but guard does not control this block (different basic block)
        // Not redundant because guard's block is separate and v could be modified between them
        if (v == 3) { // [REPORTED LINE]
            System.out.println("Test block");
        }
    }
}