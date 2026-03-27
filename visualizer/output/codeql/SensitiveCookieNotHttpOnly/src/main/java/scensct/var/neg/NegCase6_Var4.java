// Sensitive cookie name with only addCookie calls having setMaxAge(0) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var4 {
    public void setCookie(HttpServletResponse response) {
        String[] parts = {"ke", "y"};
        String name = parts[0] + parts[1];
        Cookie cookie = new Cookie(name, "value");
        cookie.setMaxAge(0);
        if (response != null) {
            response.addCookie(cookie);
        }
    }
}