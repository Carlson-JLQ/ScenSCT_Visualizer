// Sensitive cookie name with only addCookie calls having setMaxAge(0) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var2 {
    private Cookie createSessionCookie(String name, String val) {
        Cookie cookie = new Cookie(name, val);
        cookie.setMaxAge(0);
        return cookie;
    }

    public void setCookie(HttpServletResponse response) {
        String sensitive = "key";
        Cookie cookie = createSessionCookie(sensitive, "value");
        response.addCookie(cookie);
    }
}