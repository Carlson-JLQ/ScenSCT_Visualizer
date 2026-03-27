// Sensitive cookie name with addCookie calls having setHttpOnly(true) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase5_Var3 {
    // Variant 3: Extract cookie creation and flag setting into a private method
    private Cookie makeSecureCookie(String name, String val) {
        Cookie c = new Cookie(name, val);
        c.setHttpOnly(true);
        return c;
    }

    public void setCookie(HttpServletResponse response) {
        Cookie cookie = makeSecureCookie("credential", "value");
        response.addCookie(cookie);
    }
}