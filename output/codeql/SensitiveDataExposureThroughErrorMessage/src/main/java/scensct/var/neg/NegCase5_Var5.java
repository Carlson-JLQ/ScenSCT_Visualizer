// Throwable.getMessage() result not flowing to the given EXPR should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase5_Var5 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 5: Inline the getMessage call into a formatted log statement
        // Still avoiding out.write
        System.err.format("Throwable message: %s%n", t.getMessage());
    }
}