// Method receives user-provided string from HTTP request parameter and matches against polynomial backtracking regex without sanitization should be flagged as ReDoS.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var1 {
    public void processRequest(HttpServletRequest request) {
        String data = request.getParameter("input");
        final String PATTERN = "(a+)+b";
        boolean result = data.matches(PATTERN); // [REPORTED LINE]
        System.out.println(result);
    }
}