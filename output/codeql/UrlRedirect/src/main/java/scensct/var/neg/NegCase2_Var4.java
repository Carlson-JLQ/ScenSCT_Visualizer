// Untrusted user input flows to a non-redirection sink should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase2_Var4 {
    private static final Logger LOG = Logger.getLogger(NegCase2_Var4.class.getName());
    
    public void processRequest(HttpServletRequest request) {
        // Variant 4: Use a StringBuilder for log message construction.
        StringBuilder sb = new StringBuilder();
        sb.append("Received: ");
        sb.append(request.getParameter("data"));
        LOG.info(sb.toString());
    }
}