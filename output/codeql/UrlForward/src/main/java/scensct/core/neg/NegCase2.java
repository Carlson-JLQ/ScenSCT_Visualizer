// An ActiveThreatModelSource and a URL forward sink exist with no taint flow between them should not be flagged.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NegCase2 {
    public void doForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Source: ActiveThreatModelSource (excluding request URI/URL/path), e.g., getParameter
        String userInput = request.getParameter("input");
        // No flow to sink; sink uses a different, safe variable
        String safePath = "/home.jsp";
        // Sink: URL forward sink
        request.getRequestDispatcher(safePath).forward(request, response);
    }
}