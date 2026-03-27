// Untrusted user input flows to a non-redirection sink should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase2_Var5 {
    private static final Logger LOG = Logger.getLogger(NegCase2_Var5.class.getName());
    
    public void processRequest(HttpServletRequest request) {
        // Variant 5: Store parameter in an array before logging.
        String[] params = new String[1];
        params[0] = request.getParameter("data");
        LOG.info("Received: " + params[0]);
    }
}