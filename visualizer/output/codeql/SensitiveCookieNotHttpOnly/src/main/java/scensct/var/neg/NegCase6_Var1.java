// Sensitive cookie name with only addCookie calls having setMaxAge(0) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var1 {
    public void setCookie(HttpServletResponse response) {
        final String cookieName = "key";
        Cookie c = new Cookie(cookieName, "value");
        c.setMaxAge(0);
        response.addCookie(c);
    }
}