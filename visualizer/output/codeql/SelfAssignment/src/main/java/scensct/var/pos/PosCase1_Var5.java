// Instance field self-assignment within the same class should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase1_Var5 {
    private int x;

    public void method() {
        // Variant 5: Try-finally block that does not affect the assignment.
        try {
            x = x; // Should trigger report // [REPORTED LINE]
        } finally {
            // No-op
        }
    }
}