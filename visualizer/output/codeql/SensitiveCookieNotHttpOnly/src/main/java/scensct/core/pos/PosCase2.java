// A compile-time constant sensitive cookie name passed to Cookie constructor flows to addHeader without httponly should be flagged as positive.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase2 {
    public void test(HttpServletResponse response) {
        // compile-time constant sensitive name
        Cookie cookie = new Cookie("authToken", "value");
        cookie.setPath("/");
        // Cookie object flows to addHeader
        response.addHeader("set-cookie", cookie.toString()); // no "httponly" substring // [REPORTED LINE]
    }
}