// Method receives user-provided string from HTTP request parameter and matches against polynomial backtracking regex without sanitization should be flagged as ReDoS.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1 {
    public void processRequest(HttpServletRequest request) {
        String userInput = request.getParameter("input"); // User-provided string from HTTP request parameter
        boolean matches = userInput.matches("(a+)+b"); // Polynomial backtracking regex match without sanitization // [REPORTED LINE]
        System.out.println(matches);
    }
}