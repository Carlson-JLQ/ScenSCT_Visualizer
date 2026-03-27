// Calling super.finalize() within an overriding finalize method should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase2_Var2 {
    @Override
    protected void finalize() throws Throwable {
        try {
            // Explicit super call inside try
            super.finalize();
        } catch (Throwable t) {
            throw t;
        } finally {
            // Empty finally, no extra finalize calls
        }
    }
}