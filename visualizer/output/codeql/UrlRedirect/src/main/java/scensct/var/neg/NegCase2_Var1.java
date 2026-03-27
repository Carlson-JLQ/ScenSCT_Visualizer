// Untrusted user input flows to a non-redirection sink should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase2_Var1 {
    private static final Logger LOG = Logger.getLogger(NegCase2_Var1.class.getName());
    
    public void processRequest(HttpServletRequest request) {
        // Variant 1: Introduce a temporary variable and change concatenation style.
        String input = request.getParameter("data");
        String logMessage = "Received: ".concat(input);
        LOG.info(logMessage);
    }
}