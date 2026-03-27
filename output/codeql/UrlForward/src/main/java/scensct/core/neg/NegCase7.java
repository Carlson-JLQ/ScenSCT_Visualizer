// A taint flow from an ActiveThreatModelSource to a URL forward sink passing through a UrlPathBarrier should not be flagged.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class NegCase7 {
    public void doForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Source: ActiveThreatModelSource
        String userInput = request.getParameter("input");
        // Flow passes through a UrlPathBarrier: URL encoding
        String encoded = URLEncoder.encode(userInput, StandardCharsets.UTF_8.name());
        // Sink: URL forward sink
        request.getRequestDispatcher(encoded).forward(request, response);
    }
}