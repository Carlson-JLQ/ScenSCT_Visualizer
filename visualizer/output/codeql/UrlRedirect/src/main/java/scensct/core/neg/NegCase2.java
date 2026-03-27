// Untrusted user input flows to a non-redirection sink should not be flagged as untrusted URL redirection.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase2 {
    private static final Logger LOG = Logger.getLogger(NegCase2.class.getName());
    
    public void processRequest(HttpServletRequest request) {
        // Scenario 2: User input source exists but flows to logging, not a URL redirection sink.
        String userParam = request.getParameter("data");
        LOG.info("Received: " + userParam);
    }
}