// Directly using a tainted method parameter as the format string in String.format should be flagged as a format string vulnerability.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.util.Formatter;

public class PosCase1_Var4 {
    // Variant 4: Idiomatic variation using Formatter class directly
    public static void vulnerableFormat(HttpServletRequest request) {
        String format = request.getParameter("format");
        Formatter formatter = new Formatter();
        formatter.format(format, "safeArgument"); // [REPORTED LINE]
        String result = formatter.toString();
        System.out.println(result);
        formatter.close();
    }

    public static void main(String[] args) {
        // placeholder
    }
}