// Sensitive data from getParameter flows into Cookie value and cookie is added to HttpServletResponse should be flagged as storing sensitive data in cleartext cookie.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var4 {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        // Aliasing and expression rewrite: chain assignments and use constructor directly
        String input = request.getParameter("password");
        String value = input;
        response.addCookie(new Cookie("session", value)); // [REPORTED LINE]
    }
}