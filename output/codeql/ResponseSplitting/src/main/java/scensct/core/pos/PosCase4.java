// Tainted data flows into HTTP header with String.replaceAll using wrong pattern should be flagged as HTTP response splitting.
package scensct.core.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PosCase4 {
    public void doGet(HttpServletResponse resp, String userInput) throws IOException {
        // ActiveThreatModelSource: userInput is tainted
        // Barrier node: String.replaceAll with constant pattern that doesn't remove CR/LF
        String sanitized = userInput.replaceAll("wrong", "safe"); // Pattern doesn't match \r or \n
        resp.setHeader("X-Custom-Header", sanitized); // HeaderSplittingSink
    }
}