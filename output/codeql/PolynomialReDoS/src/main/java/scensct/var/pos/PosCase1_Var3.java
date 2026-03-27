// Method receives user-provided string from HTTP request parameter and matches against polynomial backtracking regex without sanitization should be flagged as ReDoS.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var3 {
    public void processRequest(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        boolean matches = checkPattern(userInput);
        System.out.println(matches);
    }

    private boolean checkPattern(String s) {
        return s.matches("(a+)+b"); // [REPORTED LINE]
    }
}