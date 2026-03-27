// A program where user-provided data flows but not to a JEXL sink should not be flagged as JEXL injection.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NegCase2 {
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        String userInput = req.getParameter("data"); // Source
        String processed = userInput.toUpperCase(); // Flow through code
        // No JEXL evaluation method called with tainted data
        resp.getWriter().println(processed); // Safe usage elsewhere
    }
}