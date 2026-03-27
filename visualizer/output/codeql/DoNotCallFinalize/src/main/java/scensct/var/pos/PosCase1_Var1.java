// Overriding finalize() with a direct finalize() call should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var1 {
    @Override
    protected void finalize() throws Throwable {
        // Wrapped in a conditional that always executes
        if (System.currentTimeMillis() > 0) {
            finalize(); // Direct call remains reachable // [REPORTED LINE]
        }
        super.finalize();
    }
}