// Tainted user input flows but stops before reaching XSLT sink (used in condition).
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase4 {
    public void handleRequest(HttpServletRequest request) {
        // Scenario 4: Tainted input obtained.
        String userParam = request.getParameter("mode");
        // Flow stops: used in a condition, not passed to XSLT sink.
        if ("debug".equals(userParam)) {
            System.out.println("Debug mode enabled");
        }
        // No further propagation to XSLT operations.
    }
}