// Calling a method whose name is not "getMessage" should not be flagged as sensitive data exposure.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase1_Var1 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 1: Use getLocalizedMessage instead of toString, still not getMessage
        String errorDetail = t.getLocalizedMessage();
        out.print(errorDetail);
    }
}