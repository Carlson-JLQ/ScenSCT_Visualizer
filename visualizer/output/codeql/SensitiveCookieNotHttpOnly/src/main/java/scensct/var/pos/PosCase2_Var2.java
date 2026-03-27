// A compile-time constant sensitive cookie name passed to Cookie constructor flows to addHeader without httponly should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var2 {
    // Variant 2: Intra-procedural refactoring - split into multiple steps with temporaries
    public void test(HttpServletResponse response) {
        String name = "authToken";
        Cookie c = makeCookie(name);
        attachCookie(response, c);
    }

    private Cookie makeCookie(String name) {
        Cookie c = new Cookie(name, "value");
        c.setPath("/");
        return c;
    }

    private void attachCookie(HttpServletResponse resp, Cookie c) {
        resp.addHeader("set-cookie", c.toString()); // no httponly // [REPORTED LINE]
    }
}