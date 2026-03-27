// Tainted data flows into HTTP header with String.replace using variable first argument should be flagged as HTTP response splitting.
package scensct.core.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PosCase3 {
    public void doGet(HttpServletResponse resp, String userInput, String replacement) throws IOException {
        // ActiveThreatModelSource: userInput is tainted
        // Barrier node: String.replace with non-constant first argument
        String sanitized = userInput.replace(replacement, "safe");
        resp.setHeader("X-Custom-Header", sanitized); // HeaderSplittingSink
    }
}