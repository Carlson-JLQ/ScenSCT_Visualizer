// Throwable.getMessage() result flows to a non-HTTP response sink should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase6_Var2 {
    // Variant 2: Control-flow restructuring with conditional logging
    public void handleError(Throwable t) {
        String msg = t.getMessage();
        if (msg != null && !msg.isEmpty()) {
            System.err.println("Error: " + msg);
        } else {
            System.err.println("Unknown error occurred");
        }
    }
}