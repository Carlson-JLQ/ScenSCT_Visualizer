// A compile-time constant sensitive cookie name passed to Cookie constructor flows to addHeader without httponly should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var5 {
    // Variant 5: Control-flow restructuring with try-finally (no effect on cookie)
    public void test(HttpServletResponse response) {
        Cookie cookie = null;
        try {
            cookie = new Cookie("authToken", "value");
            cookie.setPath("/");
        } finally {
            // ensure cookie is added even if exception occurs earlier (though none here)
            if (cookie != null) {
                response.addHeader("set-cookie", cookie.toString()); // no httponly // [REPORTED LINE]
            }
        }
    }
}