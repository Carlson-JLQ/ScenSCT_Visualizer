// Tainted source used only in non-path operations should not be flagged as path injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var4 {
    // Variant 4: Loop and temporary variable obfuscation
    public void processRequest(HttpServletRequest request) {
        String[] params = { "data" };
        StringBuilder output = new StringBuilder();
        for (String p : params) {
            String val = request.getParameter(p);
            if (val != null) {
                output.append(val);
            }
        }
        // Still a non-path sink, but built via StringBuilder
        System.out.println("Received: " + output.toString());
    }
}