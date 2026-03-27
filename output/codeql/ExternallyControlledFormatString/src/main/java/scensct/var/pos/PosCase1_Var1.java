// Directly using a tainted method parameter as the format string in String.format should be flagged as a format string vulnerability.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var1 {
    // Variant 1: Lexical refactoring with temporary and expression split
    public static void vulnerableFormat(HttpServletRequest request) {
        String userInput = request.getParameter("format");
        String fmt = userInput;
        String output = String.format(fmt, "safeArgument"); // [REPORTED LINE]
        System.out.println(output);
    }

    public static void main(String[] args) {
        // placeholder
    }
}