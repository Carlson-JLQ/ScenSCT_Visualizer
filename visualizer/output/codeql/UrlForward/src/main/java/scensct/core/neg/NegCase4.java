// A taint flow from an ActiveThreatModelSource to a non-forward sink (not DefaultUrlForwardSink and not in Spring mapping) should not be flagged.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase4 {
    public void doSendRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Source: ActiveThreatModelSource, e.g., getParameter
        String userInput = request.getParameter("page");
        // Sink: sendRedirect is NOT a DefaultUrlForwardSink and not a forward operation
        response.sendRedirect(userInput);
    }
}