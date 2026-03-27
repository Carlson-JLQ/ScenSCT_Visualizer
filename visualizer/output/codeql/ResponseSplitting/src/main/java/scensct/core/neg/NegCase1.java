// Hardcoded string source should not be flagged as HTTP response splitting vulnerability
package scensct.core.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1 {
    public void testHardcodedSource(HttpServletResponse response) throws IOException {
        // Source: hardcoded string (not ActiveThreatModelSource)
        String headerValue = "Content-Type: application/json";
        
        // Sink: HTTP header setter (potential HeaderSplittingSink)
        response.setHeader("X-Custom-Header", headerValue);
    }
}