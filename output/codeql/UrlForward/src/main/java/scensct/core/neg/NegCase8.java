// A taint flow from an ActiveThreatModelSource to a URL forward sink passing through a barrier prefix containing "?" should not be flagged.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NegCase8 {
    public void doForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Source: ActiveThreatModelSource
        String userInput = request.getParameter("input");
        // Flow passes through a barrier prefix containing "?" (query string)
        String pathWithQuery = "/page.jsp?param=" + userInput;
        // Sink: URL forward sink
        request.getRequestDispatcher(pathWithQuery).forward(request, response);
    }
}