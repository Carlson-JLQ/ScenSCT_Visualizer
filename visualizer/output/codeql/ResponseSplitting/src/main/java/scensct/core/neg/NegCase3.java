// Unsafe source flowing to non-header sink should not be flagged as HTTP response splitting vulnerability
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase3 {
    private static final Logger LOG = Logger.getLogger(NegCase3.class.getName());
    
    public void testNonHeaderSink(HttpServletRequest request) {
        // Source: unsafe ActiveThreatModelSource (request parameter)
        String userInput = request.getParameter("data");
        
        // Sink: log file (not HeaderSplittingSink)
        LOG.info("User data: " + userInput);
    }
}