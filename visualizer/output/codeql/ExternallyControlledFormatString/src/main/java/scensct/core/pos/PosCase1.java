// Directly using a tainted method parameter as the format string in String.format should be flagged as a format string vulnerability.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1 {
    // The method parameter 'request' is externally controlled.
    public static void vulnerableFormat(HttpServletRequest request) {
        // Tainted data flows directly to format string argument
        String format = request.getParameter("format");
        String result = String.format(format, "safeArgument"); // [REPORTED LINE]
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Simulate a request; in real execution, this would be provided by a servlet container.
        // This main method is kept for compilation but may not be executed in a servlet context.
        // The scenario remains: user input from HTTP request.
    }
}