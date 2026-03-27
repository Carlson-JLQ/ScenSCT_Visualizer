// Calling a parameterized method named "getMessage" should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase3_Var4 {
    public void handleError(Throwable t, PrintWriter out) {
        // Use an interface to invoke getMessage
        MessageProvider mp = new CustomThrowable();
        String msg = mp.getMessage("prefix");
        out.write(msg);
    }
    
    interface MessageProvider {
        String getMessage(String prefix);
    }
    
    static class CustomThrowable implements MessageProvider {
        public String getMessage(String prefix) {
            return prefix + " error";
        }
    }
}