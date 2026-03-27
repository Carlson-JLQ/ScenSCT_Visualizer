// Throwable.getMessage() result not flowing to the given EXPR should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase5_Var2 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 2: Extract logging to a helper method
        String msg = t.getMessage();
        logErrorInternally(msg);
        // out.write is never called
    }

    private void logErrorInternally(String message) {
        System.err.println("[Internal] " + message);
    }
}