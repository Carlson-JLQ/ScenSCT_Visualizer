// User-controlled input from HttpServletRequest.getParameter flows unsanitized into Runtime.exec should be flagged as command injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var4 {
    // Variant 4: Inter-procedural refactoring - extract sink to a helper method
    private void runCommand(String command) throws java.io.IOException {
        Runtime.getRuntime().exec(command); // [REPORTED LINE]
    }

    public void executeCommand(HttpServletRequest request) throws java.io.IOException {
        String userInput = request.getParameter("cmd");
        runCommand(userInput);
    }
}