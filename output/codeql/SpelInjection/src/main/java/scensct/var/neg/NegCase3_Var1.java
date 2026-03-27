// Threat source flows but does not reach any SpEL evaluation sink.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var1 {
    public void handleRequest(HttpServletRequest request) {
        String rawInput = request.getParameter("data");
        // Introduce alias and temporary variable
        String alias = rawInput;
        String sanitized = alias.replaceAll("\\s+", " ").strip();
        // Conditional branch that never reaches a SpEL sink
        if (sanitized.length() > 0) {
            System.err.println("Processing: " + sanitized);
        } else {
            System.out.println("Empty input ignored");
        }
        // Still no SpEL evaluation
    }
}