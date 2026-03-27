// User-controlled input from HttpServletRequest.getParameter flows unsanitized into Runtime.exec should be flagged as command injection.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1 {
    public void executeCommand(HttpServletRequest request) throws java.io.IOException {
        String userInput = request.getParameter("cmd"); // Source: HttpServletRequest.getParameter
        Runtime.getRuntime().exec(userInput); // Sink: Runtime.exec, unsanitized flow // [REPORTED LINE]
    }
}