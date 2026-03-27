// Calling a method whose name is not "getMessage" should not be flagged as sensitive data exposure.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase1_Var5 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 5: Wrap in try-catch, but still use non-getMessage method
        try {
            String msg = t.toString();
            out.write(msg);
        } catch (Exception e) {
            out.write("Error handling failed");
        }
    }
}