// Untrusted user input flows to a non-redirection sink should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase2_Var3 {
    private static final Logger LOG = Logger.getLogger(NegCase2_Var3.class.getName());
    
    private void logReceivedData(String data) {
        // Helper method that performs logging (non-redirection sink).
        LOG.info("Received: " + data);
    }
    
    public void processRequest(HttpServletRequest request) {
        // Variant 3: Extract logging to a separate method.
        String userParam = request.getParameter("data");
        logReceivedData(userParam);
    }
}