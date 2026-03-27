// User-provided input flows into redirect with sanitization logic present but not applied on this path should be flagged.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2 {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String target = request.getParameter("url"); // User-provided input
        // Sanitization method exists but is not called before the redirect
        response.sendRedirect(target); // Unsanitized flow to redirect sink // [REPORTED LINE]
    }
    
    // Sanitization logic present elsewhere (not applied to the above path)
    private String sanitizeUrl(String url) {
        if (url != null && url.startsWith("/")) {
            return url;
        }
        return "/default";
    }
}