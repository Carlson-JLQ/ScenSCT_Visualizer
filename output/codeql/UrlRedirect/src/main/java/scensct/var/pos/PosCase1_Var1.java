// User-provided input flows directly into sendRedirect without validation should be flagged as untrusted URL redirection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var1 {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Variant 1: Lexical refactoring with temporary variable and renamed identifiers
        String userSuppliedUrl = request.getParameter("url");
        String redirectDestination = userSuppliedUrl;
        response.sendRedirect(redirectDestination); // [REPORTED LINE]
    }
}