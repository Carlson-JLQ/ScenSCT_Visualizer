// Numeric-only source should not be flagged as HTTP response splitting vulnerability
package scensct.core.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase2 {
    public void testNumericSource(HttpServletResponse response, com.exp.AnotherClass source) throws IOException {
        // Source: ActiveThreatModelSource that returns only numeric data (SafeHeaderSplittingSource)
        String userId = source.getNumericUserId(); // Returns only digits
        
        // Sink: HTTP header setter (potential HeaderSplittingSink)
        response.setHeader("X-User-ID", userId);
    }
}