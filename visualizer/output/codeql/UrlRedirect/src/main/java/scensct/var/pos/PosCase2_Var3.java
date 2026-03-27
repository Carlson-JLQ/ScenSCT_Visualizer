// User-provided input flows into redirect with sanitization logic present but not applied on this path should be flagged.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var3 {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String input = request.getParameter("url");
        // Delegate to a helper method that still passes unsanitized input
        performRedirect(input, response);
    }
    
    private void performRedirect(String location, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(location); // [REPORTED LINE]
    }
    
    private String sanitizeUrl(String url) {
        if (url != null && url.startsWith("/")) {
            return url;
        }
        return "/default";
    }
}