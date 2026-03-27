// Method receives user-provided string from HTTP request parameter and matches against polynomial backtracking regex without sanitization should be flagged as ReDoS.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PosCase1_Var4 {
    public void processRequest(HttpServletRequest request) {
        String param = request.getParameter("input");
        Pattern p = Pattern.compile("(a+)+b");
        Matcher m = p.matcher(param); // [REPORTED LINE]
        boolean found = m.matches();
        System.out.println(found);
    }
}