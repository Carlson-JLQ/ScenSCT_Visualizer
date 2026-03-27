// Tainted source used only in non-path operations should not be flagged as path injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var1 {
    public void processRequest(HttpServletRequest request) {
        // Variant 1: Lexical & control-flow restructuring
        // Introduce a temporary and an irrelevant conditional branch
        String raw = request.getParameter("data");
        String userInput = raw != null ? raw.trim() : "";
        if (userInput.isEmpty()) {
            System.out.println("No input received");
        } else {
            System.out.println("Received: " + userInput);
        }
    }
}