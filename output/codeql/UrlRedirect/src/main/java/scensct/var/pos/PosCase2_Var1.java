// User-provided input flows into redirect with sanitization logic present but not applied on this path should be flagged.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var1 {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String urlParam = req.getParameter("url");
        // Introduce a temporary variable and a no-effect branch
        String redirectTarget = urlParam;
        if (System.currentTimeMillis() > 0) { // always true, but adds control flow
            resp.sendRedirect(redirectTarget); // [REPORTED LINE]
        }
    }
    
    private String sanitizeUrl(String url) {
        if (url != null && url.startsWith("/")) {
            return url;
        }
        return "/default";
    }
}