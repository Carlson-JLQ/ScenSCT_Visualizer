// String from HttpServletRequest.getParameter flows directly into Pattern.compile should be flagged as regex injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        try {
            HttpServletRequest request = null;
            String userInput = request.getParameter("pattern");
            Pattern.compile(userInput); // [REPORTED LINE]
        } catch (Exception e) {
            // Swallow exception - does not affect taint flow
        }
    }
}