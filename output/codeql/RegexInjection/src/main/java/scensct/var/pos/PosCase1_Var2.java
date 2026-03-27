// String from HttpServletRequest.getParameter flows directly into Pattern.compile should be flagged as regex injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        HttpServletRequest request = null;
        String input = request.getParameter("pattern");
        // Temporary variable and reordered statements
        String unsafePattern = input.trim(); // trim does NOT sanitize for regex injection
        Pattern.compile(unsafePattern); // [REPORTED LINE]
    }
}