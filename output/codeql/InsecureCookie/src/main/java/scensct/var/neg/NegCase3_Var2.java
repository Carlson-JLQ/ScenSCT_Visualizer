// A Java source file containing a call to addCookie on javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse where the argument is a Cookie object that has been set as secure (e.g., via setSecure(true)) should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class NegCase3_Var2 {
    // Variant 2: Extract secure flag setting into a separate method call
    public void addSecureCookie(HttpServletResponse response) {
        Cookie c = makeSecureCookie("sessionId", "abc123");
        response.addCookie(c);
    }
    
    private Cookie makeSecureCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(true);
        return cookie;
    }
}