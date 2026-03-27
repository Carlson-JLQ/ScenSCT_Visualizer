// A Java source file containing a call to addCookie on javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse where the argument is a Cookie object that has been set as secure (e.g., via setSecure(true)) should not be flagged as insecure cookie.
package scensct.core.neg;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class NegCase3 {
    public void addSecureCookie(HttpServletResponse response) {
        Cookie secureCookie = new Cookie("sessionId", "abc123");
        secureCookie.setSecure(true); // Cookie explicitly set as secure
        response.addCookie(secureCookie); // Should not be flagged
    }
}