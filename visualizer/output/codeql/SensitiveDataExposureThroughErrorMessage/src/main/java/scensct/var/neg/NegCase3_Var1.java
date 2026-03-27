// Calling a parameterized method named "getMessage" should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase3_Var1 {
    public void handleError(Throwable t, PrintWriter out) {
        CustomThrowable ct = new CustomThrowable();
        // Introduce a temporary variable and a conditional that doesn't affect data flow
        String prefix = "prefix";
        if (out != null) {
            String msg = ct.getMessage(prefix);
            out.write(msg);
        }
    }
    
    static class CustomThrowable {
        public String getMessage(String prefix) {
            return prefix + " error";
        }
    }
}