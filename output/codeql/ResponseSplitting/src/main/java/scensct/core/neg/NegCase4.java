// Sanitized unsafe source should not be flagged as HTTP response splitting vulnerability
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase4 {
    public void testSanitizedFlow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Source: unsafe ActiveThreatModelSource (request parameter)
        String userInput = request.getParameter("headerValue");
        
        // Barrier: sanitize newline/carriage return characters
        String sanitized = userInput.replaceAll("[\n\r]", "");
        
        // Sink: HTTP header setter (HeaderSplittingSink)
        response.setHeader("X-Custom-Data", sanitized);
    }
}