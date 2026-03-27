// Calling a parameterized method named "getMessage" should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase3_Var3 {
    public void handleError(Throwable t, PrintWriter out) {
        CustomThrowable ct = new CustomThrowable();
        // Wrap the call inside a try-catch that doesn't alter the data flow
        try {
            String msg = ct.getMessage("prefix");
            out.write(msg);
        } catch (RuntimeException e) {
            // ignore
        }
    }
    
    static class CustomThrowable {
        public String getMessage(String prefix) {
            return prefix + " error";
        }
    }
}