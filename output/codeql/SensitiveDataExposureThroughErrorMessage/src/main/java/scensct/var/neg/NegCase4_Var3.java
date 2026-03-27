// Calling a parameterless getMessage from a non-Throwable type should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase4_Var3 {
    public void handleError(PrintWriter out) {
        // Variant 3: Inter-procedural refactoring - extract message retrieval to a helper method
        String msg = obtainMessage(new MessageProvider());
        out.write(msg);
    }
    
    private String obtainMessage(MessageProvider mp) {
        return mp.getMessage();
    }
    
    static class MessageProvider {
        public String getMessage() {
            return "Some message";
        }
    }
}