// Throwable.getMessage() result flows to a non-HTTP response sink should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase6_Var3 {
    // Variant 3: Inter-procedural refactoring with helper method
    public void handleError(Throwable t) {
        logToStdErr(t.getMessage());
    }
    
    private void logToStdErr(String message) {
        System.err.println(message);
    }
}