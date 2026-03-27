// Overriding finalize() with a direct finalize() call should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var4 {
    @Override
    protected void finalize() throws Throwable {
        // Restructure with a loop that executes exactly once
        for (int i = 0; i < 1; i++) {
            finalize(); // [REPORTED LINE]
        }
        super.finalize();
    }
}