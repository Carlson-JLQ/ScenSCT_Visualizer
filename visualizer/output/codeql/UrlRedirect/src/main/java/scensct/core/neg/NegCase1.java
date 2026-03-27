// Constant string passed to sendRedirect should not be flagged as untrusted URL redirection.
package scensct.core.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1 {
    public void doGet(HttpServletResponse response) throws IOException {
        // Scenario 1: Sink uses a constant, no user input source.
        response.sendRedirect("/trusted/home.jsp");
    }
}