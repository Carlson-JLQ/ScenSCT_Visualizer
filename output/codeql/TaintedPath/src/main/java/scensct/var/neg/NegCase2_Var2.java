// Tainted source used only in non-path operations should not be flagged as path injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var2 {
    // Variant 2: Inter-procedural extraction
    // Move the logging to a separate method
    public void processRequest(HttpServletRequest request) {
        String userInput = extractInput(request);
        logInput(userInput);
    }

    private String extractInput(HttpServletRequest req) {
        return req.getParameter("data");
    }

    private void logInput(String msg) {
        System.out.println("Received: " + msg);
    }
}