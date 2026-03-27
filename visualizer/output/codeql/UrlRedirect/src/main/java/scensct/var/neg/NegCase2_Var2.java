// Untrusted user input flows to a non-redirection sink should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase2_Var2 {
    private static final Logger LOG = Logger.getLogger(NegCase2_Var2.class.getName());
    
    public void processRequest(HttpServletRequest request) {
        // Variant 2: Wrap in a conditional branch, but still log.
        String userParam = request.getParameter("data");
        if (userParam != null && !userParam.isEmpty()) {
            LOG.info("Received: " + userParam);
        } else {
            LOG.warning("No data received");
        }
    }
}