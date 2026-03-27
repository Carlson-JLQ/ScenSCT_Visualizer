// Calling a method other than a specific non-getMessage method M should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase2_Var4 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 4: Chain calls and use a different output method
        out.append(t.getLocalizedMessage()).flush();
    }
}