// Sensitive data from getParameter flows into Cookie value and cookie is added to HttpServletResponse should be flagged as storing sensitive data in cleartext cookie.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1 {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        // Sensitive data from request parameter
        String sensitiveData = request.getParameter("password");
        // Cookie created with sensitive data as value
        Cookie cookie = new Cookie("session", sensitiveData);
        // Cookie added to response
        response.addCookie(cookie); // [REPORTED LINE]
    }
}