// Sensitive data from getParameter flows into Cookie value and cookie is added to HttpServletResponse should be flagged as storing sensitive data in cleartext cookie.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var3 {
    // Inter-procedural refactoring: extract cookie creation and addition
    private void addCookieToResponse(HttpServletResponse resp, String name, String value) {
        Cookie c = new Cookie(name, value);
        resp.addCookie(c); // [REPORTED LINE]
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String sensitiveData = request.getParameter("password");
        addCookieToResponse(response, "session", sensitiveData);
    }
}