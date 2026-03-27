// Calling a parameterless getMessage from a non-Throwable type should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase4_Var2 {
    public void handleError(PrintWriter out) {
        // Variant 2: Intra-procedural refactoring - introduce temporary, conditional flow that always executes
        MessageProvider mp = new MessageProvider();
        String msg = null;
        if (out != null) {
            msg = mp.getMessage();
        } else {
            msg = mp.getMessage();
        }
        out.write(msg);
    }
    
    static class MessageProvider {
        public String getMessage() {
            return "Some message";
        }
    }
}