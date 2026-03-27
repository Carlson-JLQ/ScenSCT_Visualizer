// A taint flow from a constant string to a URL forward sink should not be flagged as untrusted URL forward.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NegCase1 {
    public void doForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Source: constant string, not an ActiveThreatModelSource
        String path = "/safePage.jsp";
        // Sink: URL forward sink (Servlet forward)
        request.getRequestDispatcher(path).forward(request, response);
    }
}