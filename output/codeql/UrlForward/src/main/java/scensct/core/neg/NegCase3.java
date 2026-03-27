// A taint flow from HttpServletRequest.getRequestURI() to a URL forward sink should not be flagged.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NegCase3 {
    public void doForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Source: getRequestURI(), which is excluded from ActiveThreatModelSource for this checker
        String uri = request.getRequestURI();
        // Sink: URL forward sink
        request.getRequestDispatcher(uri).forward(request, response);
    }
}