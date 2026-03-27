// A taint flow from an ActiveThreatModelSource to a URL forward sink passing through a URL encoding check and repeated decode should not be flagged.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class NegCase9 {
    public void doForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Source: ActiveThreatModelSource
        String userInput = request.getParameter("input");
        // Guard: URL encoding check and repeated decode
        String encoded = URLEncoder.encode(userInput, StandardCharsets.UTF_8.name());
        // Simulate a check that ensures encoding (placeholder logic)
        if (encoded.equals(URLEncoder.encode(URLDecoder.decode(encoded, StandardCharsets.UTF_8.name()), StandardCharsets.UTF_8.name()))) {
            String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8.name());
            // Sink: URL forward sink
            request.getRequestDispatcher(decoded).forward(request, response);
        }
    }
}