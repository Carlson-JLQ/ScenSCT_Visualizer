// Throwable.getMessage() result flows to a non-HTTP response sink should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase6_Var4 {
    // Variant 4: Try-catch block with redundant exception handling
    public void handleError(Throwable t) {
        try {
            String msg = t.getMessage();
            System.err.println(msg);
        } catch (RuntimeException e) {
            // Fallback: ignore and use default
            System.err.println("Failed to retrieve error message");
        }
    }
}