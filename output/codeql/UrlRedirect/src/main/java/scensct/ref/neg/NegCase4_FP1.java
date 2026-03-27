// Untrusted user input is sanitized via allowlist before reaching the URL redirection sink.
package scensct.ref.neg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase4_FP1 {
    // Simple allowlist sanitization method.
    private String sanitizeRedirectTarget(String input) {
        if ("/home".equals(input) || "/login".equals(input)) {
            return input; // Allowed values.
        }
        return "/error"; // Default safe value.
    }
    
    public void redirectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Scenario 4: User input is sanitized before reaching the sink.
        String userTarget = request.getParameter("target");
        String safeTarget = sanitizeRedirectTarget(userTarget);
        response.sendRedirect(safeTarget); // [REPORTED LINE]
    }
}