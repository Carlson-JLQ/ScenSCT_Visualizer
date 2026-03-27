// Tainted user input flows into safe logging, not into XSLT sink.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2 {
    public void processRequest(HttpServletRequest request) {
        // Scenario 2: Tainted input from request parameter.
        String userInput = request.getParameter("data");
        // Safe operation: logging the input, not passing to XSLT sink.
        System.out.println("User input: " + userInput);
    }
}