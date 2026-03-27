// Untrusted user input and URL redirection sink present, but sink uses a different trusted variable.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase3_Var4 {
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userInput = request.getParameter("page");
        String base = "/default";
        String extension = ".jsp";
        String trustedTarget = base + extension;
        response.sendRedirect(trustedTarget);
    }
}