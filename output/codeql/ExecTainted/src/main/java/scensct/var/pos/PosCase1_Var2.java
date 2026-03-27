// User-controlled input from HttpServletRequest.getParameter flows unsanitized into Runtime.exec should be flagged as command injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var2 {
    public void executeCommand(HttpServletRequest request) throws java.io.IOException {
        // Variant 2: Control flow restructuring with a trivial always-true condition
        // The flow remains direct and unsanitized.
        String userInput = request.getParameter("cmd");
        if (true) {
            Runtime.getRuntime().exec(userInput); // [REPORTED LINE]
        }
    }
}