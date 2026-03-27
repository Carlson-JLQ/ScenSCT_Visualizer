// A compile-time constant sensitive cookie name flows into a Cookie, its toString() used to construct a new Cookie passed to addCookie without safety should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var1 {
    // Variant 1: Extract cookie creation into a helper method, but keep sensitive name flow
    public void test(HttpServletResponse response) {
        String name = getSensitiveName();
        Cookie c = makeCookie(name, "value");
        response.addCookie(c); // should still report // [REPORTED LINE]
    }

    private String getSensitiveName() {
        return "sessionId";
    }

    private Cookie makeCookie(String name, String val) {
        Cookie cookie = new Cookie(name, val);
        cookie.setPath("/");
        // No setHttpOnly
        return cookie;
    }
}