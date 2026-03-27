// Sensitive data from getParameter flows into Cookie value and cookie is added to HttpServletResponse should be flagged as storing sensitive data in cleartext cookie.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var2 {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        // Control-flow restructuring: conditional that always executes the flow
        String sensitiveData = request.getParameter("password");
        if (request != null) {
            Cookie cookie = new Cookie("session", sensitiveData);
            response.addCookie(cookie); // [REPORTED LINE]
        }
    }
}