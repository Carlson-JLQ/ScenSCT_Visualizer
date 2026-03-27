// Calling a method other than a specific non-getMessage method M should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;

public class NegCase2 {
    public void handleError(Throwable t, PrintWriter out) {
        // Scenario 2: method is "getLocalizedMessage", not the specific M (e.g., "getCause")
        String msg = t.getLocalizedMessage(); // Not the specific M, so no violation
        out.write(msg);
    }
}