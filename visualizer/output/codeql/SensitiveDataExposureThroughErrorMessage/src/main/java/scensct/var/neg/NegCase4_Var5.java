// Calling a parameterless getMessage from a non-Throwable type should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase4_Var5 {
    public void handleError(PrintWriter out) {
        // Variant 5: Inter-procedural + lexical - inline class, use anonymous instance, method reference
        out.write(new MessageProvider().getMessage());
    }
    
    static class MessageProvider {
        public String getMessage() {
            return "Some message";
        }
    }
}