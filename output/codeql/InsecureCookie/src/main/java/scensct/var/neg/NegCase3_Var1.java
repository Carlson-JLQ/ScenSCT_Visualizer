// A Java source file containing a call to addCookie on javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse where the argument is a Cookie object that has been set as secure (e.g., via setSecure(true)) should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class NegCase3_Var1 {
    // Variant 1: Reorder statements, introduce a temporary variable for the cookie name
    public void addSecureCookie(HttpServletResponse response) {
        String cookieName = "sessionId";
        Cookie secureCookie = new Cookie(cookieName, "abc123");
        secureCookie.setSecure(true);
        response.addCookie(secureCookie);
    }
}