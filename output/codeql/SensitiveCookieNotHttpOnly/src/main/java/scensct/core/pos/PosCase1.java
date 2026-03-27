// A sensitive cookie name flows into a Cookie, its toString() is used in addHeader without httponly substring should be flagged as positive.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1 {
    public void test(HttpServletResponse response) {
        String sensitiveName = "sessionId"; // sensitive cookie name from variable
        Cookie cookie = new Cookie(sensitiveName, "value");
        cookie.setPath("/");
        // toString() called, result used as second argument of addHeader
        response.addHeader("set-cookie", cookie.toString()); // no "httponly" substring // [REPORTED LINE]
    }
}