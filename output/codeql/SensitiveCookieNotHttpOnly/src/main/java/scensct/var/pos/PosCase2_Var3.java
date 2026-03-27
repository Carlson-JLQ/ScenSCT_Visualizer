// A compile-time constant sensitive cookie name passed to Cookie constructor flows to addHeader without httponly should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var3 {
    // Variant 3: Inter-procedural refactoring - inline helper but with control flow
    public void test(HttpServletResponse response) {
        Cookie cookie = createSensitiveCookie();
        if (response != null) {
            response.addHeader("set-cookie", cookie.toString()); // [REPORTED LINE]
        }
    }

    private Cookie createSensitiveCookie() {
        Cookie c = new Cookie("authToken", "value");
        c.setPath("/");
        // deliberately not setting httponly
        return c;
    }
}