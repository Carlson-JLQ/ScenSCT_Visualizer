// Sensitive cookie name with addCookie calls having setHttpOnly(true) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase5_Var1 {
    // Variant 1: Split cookie instantiation and flag setting across a temporary variable
    public void setCookie(HttpServletResponse response) {
        String cookieName = "credential";
        Cookie c = new Cookie(cookieName, "value");
        boolean secure = true;
        c.setHttpOnly(secure);
        response.addCookie(c);
    }
}