// Throwable.getMessage() result not flowing to the given EXPR should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;

public class NegCase5 {
    public void handleError(Throwable t, PrintWriter out) {
        // Scenario 5: getMessage result flows to a local variable, not directly to EXPR
        String msg = t.getMessage(); // Result stored
        // EXPR (hypothetical sink) is out.write(msg), but here we don't use it
        // Instead, use msg for something else (e.g., logging)
        System.err.println(msg); // Not the given EXPR (assume EXPR is out.write)
    }
}