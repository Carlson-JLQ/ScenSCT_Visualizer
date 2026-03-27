// Calling a method other than a specific non-getMessage method M should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase2_Var2 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 2: Use a conditional that always passes, obscuring direct flow
        String msg = t.getLocalizedMessage();
        if (out != null) {
            out.write(msg);
        } else {
            out.write(msg); // unreachable but preserves flow shape
        }
    }
}