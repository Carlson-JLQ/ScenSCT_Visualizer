// Sensitive cookie name with only addCookie calls having setMaxAge(0) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var5 {
    public void setCookie(HttpServletResponse response) {
        String name = "key";
        Cookie cookie = null;
        try {
            cookie = new Cookie(name, "value");
            cookie.setMaxAge(0);
        } finally {
            if (cookie != null) {
                response.addCookie(cookie);
            }
        }
    }
}