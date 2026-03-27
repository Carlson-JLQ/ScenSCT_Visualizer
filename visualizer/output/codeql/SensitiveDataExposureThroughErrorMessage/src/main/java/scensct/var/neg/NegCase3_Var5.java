// Calling a parameterized method named "getMessage" should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase3_Var5 {
    public void handleError(Throwable t, PrintWriter out) {
        // Change the parameter to a variable expression
        String param = "pre" + "fix";
        CustomThrowable ct = new CustomThrowable();
        String msg = ct.getMessage(param);
        // Split the write into two parts
        out.write(msg.substring(0, 1)); // dummy, not the full flow
        out.write(msg); // actual flow
    }
    
    static class CustomThrowable {
        public String getMessage(String prefix) {
            return prefix + " error";
        }
    }
}