// Method receives user-provided string from HTTP request parameter and matches against polynomial backtracking regex without sanitization should be flagged as ReDoS.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var2 {
    public void processRequest(HttpServletRequest request) {
        String input = request.getParameter("input");
        if (input != null) {
            try {
                boolean matched = input.matches("(a+)+b"); // [REPORTED LINE]
                System.out.println(matched);
            } catch (IllegalArgumentException e) {
                // regex syntax is valid, so this won't happen
            }
        }
    }
}