// String from HttpServletRequest.getParameter flows directly into Pattern.compile should be flagged as regex injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class PosCase1_Var4 {
    static void compileUserPattern(HttpServletRequest req) {
        String raw = req.getParameter("p");
        Pattern.compile(raw); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        HttpServletRequest request = null;
        compileUserPattern(request);
    }
}