// Throwable.getMessage() result flows to a non-HTTP response sink should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;

public class NegCase6 {
    public void handleError(Throwable t) {
        // Scenario 6: getMessage result flows to a non-HTTP sink (e.g., system error)
        String msg = t.getMessage();
        System.err.println(msg); // Non-HTTP response sink
    }
}