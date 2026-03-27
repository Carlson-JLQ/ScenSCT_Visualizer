// Throwable.getMessage() result not flowing to the given EXPR should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase5_Var3 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 3: Temporaries and try-finally block
        String extractedMsg = null;
        try {
            extractedMsg = t.getMessage();
        } finally {
            // Ensure we log even on exception? (though getMessage rarely throws)
        }
        if (extractedMsg != null) {
            System.err.print("DEBUG: ");
            System.err.println(extractedMsg);
        }
    }
}