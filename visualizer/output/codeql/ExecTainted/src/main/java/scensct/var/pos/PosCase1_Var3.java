// User-controlled input from HttpServletRequest.getParameter flows unsanitized into Runtime.exec should be flagged as command injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - extract source to a helper method
    private String getUserInput(HttpServletRequest req) {
        return req.getParameter("cmd");
    }

    public void executeCommand(HttpServletRequest request) throws java.io.IOException {
        String cmd = getUserInput(request);
        Runtime.getRuntime().exec(cmd); // [REPORTED LINE]
    }
}