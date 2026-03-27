// User-controlled input from HttpServletRequest.getParameter flows unsanitized into Runtime.exec should be flagged as command injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var5 {
    public void executeCommand(HttpServletRequest request) throws java.io.IOException {
        // Variant 5: Aliasing and expression rewrite
        // Use a final local variable and a different way to get Runtime.
        final String data = request.getParameter("input");
        java.lang.Runtime r = java.lang.Runtime.getRuntime();
        r.exec(data); // [REPORTED LINE]
    }
}