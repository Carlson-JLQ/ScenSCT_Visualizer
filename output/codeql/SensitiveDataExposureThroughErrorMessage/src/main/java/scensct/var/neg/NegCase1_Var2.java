// Calling a method whose name is not "getMessage" should not be flagged as sensitive data exposure.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase1_Var2 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 2: Extract the non-getMessage call to a helper method
        String msg = extractMessage(t);
        out.write(msg);
    }

    private String extractMessage(Throwable ex) {
        return ex.toString();
    }
}