// Tainted source used only in non-path operations should not be flagged as path injection.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2 {
    public void processRequest(HttpServletRequest request) {
        // Tainted source: user input from request parameter
        String userInput = request.getParameter("data");
        // Non-sink usage: only printed to console (no path operation)
        System.out.println("Received: " + userInput);
    }
}