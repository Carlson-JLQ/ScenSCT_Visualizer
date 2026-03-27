// A compile-time constant sensitive cookie name flows into a Cookie, its toString() used to construct a new Cookie passed to addCookie without safety should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var5 {
    // Variant 5: Inline the cookie creation and addCookie inside a static inner class method
    public void test(HttpServletResponse response) {
        new CookieHelper(response).process();
    }

    static class CookieHelper {
        HttpServletResponse resp;
        CookieHelper(HttpServletResponse r) { this.resp = r; }
        void process() {
            String sensitiveName = "sessionId";
            Cookie cookie = new Cookie(sensitiveName, "value");
            cookie.setPath("/");
            resp.addCookie(cookie); // [REPORTED LINE]
        }
    }
}