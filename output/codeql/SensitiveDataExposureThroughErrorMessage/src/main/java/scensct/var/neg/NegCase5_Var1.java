// Throwable.getMessage() result not flowing to the given EXPR should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase5_Var1 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 1: Control-flow restructuring with early return
        String errorDetail = t.getMessage();
        if (errorDetail == null) {
            return;
        }
        // Still logging to stderr, not to the PrintWriter sink
        System.err.println("Error occurred: " + errorDetail);
    }
}