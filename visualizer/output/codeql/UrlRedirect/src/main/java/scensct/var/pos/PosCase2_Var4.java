// User-provided input flows into redirect with sanitization logic present but not applied on this path should be flagged.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var4 {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Store in an array and then retrieve
        String[] params = new String[]{request.getParameter("url")};
        String target = params[0];
        // Add a dead sanitization call that doesn't affect the used variable
        String sanitized = sanitizeUrl(target + "#dummy");
        response.sendRedirect(target); // [REPORTED LINE]
    }
    
    private String sanitizeUrl(String url) {
        if (url != null && url.startsWith("/")) {
            return url;
        }
        return "/default";
    }
}