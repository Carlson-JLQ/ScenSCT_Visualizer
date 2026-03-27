// Calling a method other than a specific non-getMessage method M should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase2_Var5 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 5: Introduce a try-finally that doesn't affect the flow
        String msg = null;
        try {
            msg = t.getLocalizedMessage();
        } finally {
            // ensure writing happens
        }
        if (msg != null) {
            out.print(msg);
        }
    }
}