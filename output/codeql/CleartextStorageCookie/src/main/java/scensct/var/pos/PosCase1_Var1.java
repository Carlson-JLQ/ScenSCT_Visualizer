// Sensitive data from getParameter flows into Cookie value and cookie is added to HttpServletResponse should be flagged as storing sensitive data in cleartext cookie.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var1 {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        // Lexical refactoring: rename variables and use temporary
        String param = request.getParameter("password");
        String data = param;
        Cookie userCookie = new Cookie("session", data);
        response.addCookie(userCookie); // [REPORTED LINE]
    }
}