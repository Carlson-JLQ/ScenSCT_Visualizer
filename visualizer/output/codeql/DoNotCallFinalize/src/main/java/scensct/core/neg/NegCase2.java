// Calling super.finalize() within an overriding finalize method should not be flagged as a prohibited finalize call.
package scensct.core.neg;

public class NegCase2 {
    @Override
    protected void finalize() throws Throwable {
        // Scenario 2: explicit super.finalize() call inside overriding finalize
        super.finalize();
    }
}