// String from HttpServletRequest.getParameter flows directly into Pattern.compile should be flagged as regex injection.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class PosCase1 {
    public static void main(String[] args) {
        // Simulating a servlet request scenario
        HttpServletRequest request = null; // Placeholder; actual request would be provided in a container
        String userInput = request.getParameter("pattern"); // Source: user-controlled input
        Pattern.compile(userInput); // Sink: unsanitized input used in regex compilation // [REPORTED LINE]
    }
}