// A Java source file containing a call to addCookie on javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse where the argument is a Cookie object that has been set as secure (e.g., via setSecure(true)) should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class NegCase3_Var4 {
    // Variant 4: Split cookie creation and secure setting across two lines with an intermediate variable
    public void addSecureCookie(HttpServletResponse response) {
        Cookie secureCookie;
        secureCookie = new Cookie("sessionId", "abc123");
        boolean secure = true;
        secureCookie.setSecure(secure);
        response.addCookie(secureCookie);
    }
}