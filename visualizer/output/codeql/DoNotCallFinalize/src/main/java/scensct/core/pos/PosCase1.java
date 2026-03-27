// Overriding finalize() with a direct finalize() call should be flagged as a violation.
package scensct.core.pos;

public class PosCase1 {
    @Override
    protected void finalize() throws Throwable {
        finalize(); // Direct call to finalize() without super qualifier // [REPORTED LINE]
        super.finalize();
    }
}