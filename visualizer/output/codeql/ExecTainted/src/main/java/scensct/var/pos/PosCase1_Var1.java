// User-controlled input from HttpServletRequest.getParameter flows unsanitized into Runtime.exec should be flagged as command injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var1 {
    public void executeCommand(HttpServletRequest request) throws java.io.IOException {
        // Variant 1: Lexical and intra-procedural refactoring
        // Use a different parameter name and split the call chain with a temporary variable.
        String input = request.getParameter("command");
        Runtime rt = Runtime.getRuntime();
        rt.exec(input); // [REPORTED LINE]
    }
}