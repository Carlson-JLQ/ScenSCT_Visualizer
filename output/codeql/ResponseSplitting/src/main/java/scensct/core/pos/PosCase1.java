// Tainted data from source flows into HTTP header without any sanitization should be flagged as HTTP response splitting.
package scensct.core.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PosCase1 {
    public void doGet(HttpServletResponse resp, String userInput) throws IOException {
        // ActiveThreatModelSource: userInput is tainted
        String headerValue = userInput; // No sanitization
        resp.setHeader("X-Custom-Header", headerValue); // HeaderSplittingSink
    }
}