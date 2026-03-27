// User-provided input flows directly into sendRedirect without validation should be flagged as untrusted URL redirection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var5 {
    // Variant 5: Loop restructuring with unchanged vulnerability
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] params = {request.getParameter("url")};
        for (String param : params) {
            response.sendRedirect(param); // [REPORTED LINE]
            break; // Ensures single execution
        }
    }
}