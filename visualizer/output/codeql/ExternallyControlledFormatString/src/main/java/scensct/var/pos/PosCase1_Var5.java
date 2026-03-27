// Directly using a tainted method parameter as the format string in String.format should be flagged as a format string vulnerability.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var5 {
    // Variant 5: Complex intra-procedural with loop and temporary accumulation
    public static void vulnerableFormat(HttpServletRequest request) {
        String[] parts = { request.getParameter("format") };
        String fmt = null;
        for (String part : parts) {
            fmt = part;
        }
        if (fmt != null) {
            String result = String.format(fmt, "safeArgument"); // [REPORTED LINE]
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        // placeholder
    }
}