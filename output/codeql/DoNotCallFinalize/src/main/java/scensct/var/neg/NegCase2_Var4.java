// Calling super.finalize() within an overriding finalize method should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase2_Var4 {
    @Override
    protected void finalize() throws Throwable {
        boolean done = false;
        do {
            super.finalize();
            done = true;
        } while (!done);
    }
}