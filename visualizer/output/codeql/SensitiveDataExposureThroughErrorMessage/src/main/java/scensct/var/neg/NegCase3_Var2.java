// Calling a parameterized method named "getMessage" should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase3_Var2 {
    public void handleError(Throwable t, PrintWriter out) {
        // Extract the call into a private helper method
        String response = buildResponse(new CustomThrowable());
        out.write(response);
    }
    
    private String buildResponse(CustomThrowable ct) {
        return ct.getMessage("prefix");
    }
    
    static class CustomThrowable {
        public String getMessage(String prefix) {
            return prefix + " error";
        }
    }
}