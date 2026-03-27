// Calling a method other than a specific non-getMessage method M should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase2_Var1 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 1: Split assignment and use a temporary variable
        String localizedMsg = t.getLocalizedMessage();
        String output = localizedMsg;
        out.write(output);
    }
}