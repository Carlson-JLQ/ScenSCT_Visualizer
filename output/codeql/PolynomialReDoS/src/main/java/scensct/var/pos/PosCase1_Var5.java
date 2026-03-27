// Method receives user-provided string from HTTP request parameter and matches against polynomial backtracking regex without sanitization should be flagged as ReDoS.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var5 {
    public void processRequest(HttpServletRequest request) {
        HttpServletRequest req = request;
        String text = req.getParameter("input");
        boolean ok = text.matches("(a+)+c?b"); // [REPORTED LINE]
        System.out.println(ok);
    }
}