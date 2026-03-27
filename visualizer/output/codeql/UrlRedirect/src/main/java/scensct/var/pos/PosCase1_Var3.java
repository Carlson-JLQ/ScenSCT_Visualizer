// User-provided input flows directly into sendRedirect without validation should be flagged as untrusted URL redirection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - extraction of source retrieval
    private String obtainRedirectUrl(HttpServletRequest req) {
        return req.getParameter("url");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = obtainRedirectUrl(request);
        response.sendRedirect(url); // [REPORTED LINE]
    }
}