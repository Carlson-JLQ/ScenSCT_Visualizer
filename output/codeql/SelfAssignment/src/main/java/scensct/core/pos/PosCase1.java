// Instance field self-assignment within the same class should be flagged as a self-assignment typo.
package scensct.core.pos;

public class PosCase1 {
    private int x;

    public void method() {
        // Scenario 1: Instance field self-assignment, accessed implicitly.
        x = x; // Should trigger report // [REPORTED LINE]
    }
}