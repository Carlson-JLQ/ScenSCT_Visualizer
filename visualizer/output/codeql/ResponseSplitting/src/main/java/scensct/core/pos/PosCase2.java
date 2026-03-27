// Tainted data flows into HTTP header with custom sanitization (non-String method) should be flagged as HTTP response splitting.
package scensct.core.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PosCase2 {
    // Custom sanitization method (not java.lang.String)
    private String customSanitize(String input) {
        // Some custom logic that does not guarantee removal of CR/LF
        return input.trim();
    }

    public void doGet(HttpServletResponse resp, String userInput) throws IOException {
        // ActiveThreatModelSource: userInput is tainted
        String sanitized = customSanitize(userInput); // Barrier node: custom method
        resp.setHeader("X-Custom-Header", sanitized); // HeaderSplittingSink
    }
}