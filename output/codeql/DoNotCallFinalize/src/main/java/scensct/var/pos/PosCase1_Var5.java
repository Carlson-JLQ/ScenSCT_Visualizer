// Overriding finalize() with a direct finalize() call should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var5 {
    @Override
    protected void finalize() throws Throwable {
        // Wrap in try-catch, but the direct call is still reachable
        try {
            finalize(); // [REPORTED LINE]
        } catch (Throwable t) {
            throw t;
        }
        super.finalize();
    }
}