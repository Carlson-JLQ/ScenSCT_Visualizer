// Directly using a tainted method parameter as the format string in String.format should be flagged as a format string vulnerability.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var2 {
    // Variant 2: Intra-procedural control flow with conditional that always passes
    public static void vulnerableFormat(HttpServletRequest request) {
        String format = request.getParameter("format");
        if (format != null) {
            String result = String.format(format, "safeArgument"); // [REPORTED LINE]
            System.out.println(result);
        } else {
            System.out.println("No format provided");
        }
    }

    public static void main(String[] args) {
        // placeholder
    }
}