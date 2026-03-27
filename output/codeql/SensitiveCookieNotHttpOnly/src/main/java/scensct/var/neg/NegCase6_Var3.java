// Sensitive cookie name with only addCookie calls having setMaxAge(0) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var3 {
    public void setCookie(HttpServletResponse response) {
        String name = "key";
        Cookie cookie = new Cookie(name, "value");
        int zero = 0;
        cookie.setMaxAge(zero);
        response.addCookie(cookie); // [REPORTED LINE]
    }
}