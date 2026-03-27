// User-provided input flows directly into sendRedirect without validation should be flagged as untrusted URL redirection.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1 {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String target = request.getParameter("url"); // User-provided input
        response.sendRedirect(target); // Direct flow to redirect sink without validation // [REPORTED LINE]
    }
}