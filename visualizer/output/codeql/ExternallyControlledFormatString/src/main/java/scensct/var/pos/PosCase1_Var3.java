// Directly using a tainted method parameter as the format string in String.format should be flagged as a format string vulnerability.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural extraction - taint source in helper
    public static void vulnerableFormat(HttpServletRequest request) {
        String format = getFormatString(request);
        String result = String.format(format, "safeArgument"); // [REPORTED LINE]
        System.out.println(result);
    }

    private static String getFormatString(HttpServletRequest req) {
        return req.getParameter("format");
    }

    public static void main(String[] args) {
        // placeholder
    }
}