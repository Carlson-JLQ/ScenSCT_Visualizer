// String from HttpServletRequest.getParameter flows directly into Pattern.compile should be flagged as regex injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        HttpServletRequest req = null;
        String param = req.getParameter("regex");
        Pattern pat = Pattern.compile(param); // [REPORTED LINE]
    }
}