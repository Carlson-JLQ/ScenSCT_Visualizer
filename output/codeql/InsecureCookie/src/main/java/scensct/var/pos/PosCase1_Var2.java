// Adding a cookie without setting secure flag should be flagged as insecure.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var2 {
    // Variant 2: Cookie creation and addition separated into helper method
    public void insecureCookie(HttpServletResponse response) {
        Cookie c = makeCookie("auth", "def456");
        attachCookie(response, c);
    }

    private Cookie makeCookie(String name, String value) {
        return new Cookie(name, value);
    }

    private void attachCookie(HttpServletResponse resp, Cookie cookie) {
        resp.addCookie(cookie); // [REPORTED LINE]
    }
}