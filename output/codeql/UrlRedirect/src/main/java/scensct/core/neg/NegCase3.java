// Untrusted user input and URL redirection sink present, but sink uses a different trusted variable.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase3 {
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Scenario 3: User input source and sink present, but sink uses a constant, not the user input.
        String userInput = request.getParameter("page");
        String trustedTarget = "/default.jsp";
        response.sendRedirect(trustedTarget); // Uses trusted variable, not userInput.
    }
}