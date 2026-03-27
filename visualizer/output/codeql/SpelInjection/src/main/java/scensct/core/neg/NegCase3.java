// Threat source flows but does not reach any SpEL evaluation sink.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase3 {
    public void handleRequest(HttpServletRequest request) {
        // Recognized threat source.
        String userInput = request.getParameter("data");
        // Data flows through application but not to SpEL.
        String processed = userInput.trim();
        System.out.println(processed);
        // No SpEL evaluation method is called.
    }
}