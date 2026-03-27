// Calling a parameterless getMessage from a non-Throwable type should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase4_Var1 {
    public void handleError(PrintWriter out) {
        // Variant 1: Lexical refactoring - rename locals, use explicit type, split assignment
        final MessageProvider provider = new MessageProvider();
        String errorMessage;
        errorMessage = provider.getMessage();
        out.write(errorMessage);
    }
    
    static class MessageProvider {
        public String getMessage() {
            return "Some message";
        }
    }
}