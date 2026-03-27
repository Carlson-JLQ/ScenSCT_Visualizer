// Calling a parameterless getMessage from a non-Throwable type should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;

public class NegCase4 {
    public void handleError(PrintWriter out) {
        // Scenario 4: getMessage from a different type (e.g., custom class)
        MessageProvider mp = new MessageProvider();
        String msg = mp.getMessage(); // Not Throwable.getMessage
        out.write(msg);
    }
    
    static class MessageProvider {
        public String getMessage() {
            return "Some message";
        }
    }
}