// Calling super.finalize() within an overriding finalize method should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase2_Var1 {
    @Override
    protected void finalize() throws Throwable {
        // Use a conditional that always executes
        if (System.currentTimeMillis() > 0L) {
            Object parent = this;
            // The call is still super.finalize()
            super.finalize();
        }
    }
}