// User-provided input flows into redirect with sanitization logic present but not applied on this path should be flagged.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var5 {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String target = extractUrl(request);
        response.sendRedirect(target); // [REPORTED LINE]
    }
    
    private String extractUrl(HttpServletRequest req) {
        // Still unsanitized user input
        return req.getParameter("url");
    }
    
    private String sanitizeUrl(String url) {
        if (url != null && url.startsWith("/")) {
            return url;
        }
        return "/default";
    }
}