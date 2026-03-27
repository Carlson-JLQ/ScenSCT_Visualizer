// Calling a parameterless getMessage from a non-Throwable type should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase4_Var4 {
    public void handleError(PrintWriter out) {
        // Variant 4: Idiomatic variation - use try-with-resources pattern (no resources), still call getMessage
        MessageProvider mp = new MessageProvider();
        try {
            String msg = mp.getMessage();
            out.write(msg);
        } catch (RuntimeException e) {
            // ignore, but no Throwable.getMessage involved
            out.write("fallback");
        }
    }
    
    static class MessageProvider {
        public String getMessage() {
            return "Some message";
        }
    }
}