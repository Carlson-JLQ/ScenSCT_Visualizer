// A sensitive cookie name flows into Cookie then NewCookie constructor with httpOnly false, NewCookie converted to string used in addHeader without httponly should be flagged as positive.
package scensct.ref.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.NewCookie;

public class PosCase4_FN1 {
    public void test(HttpServletResponse response) {
        String sensitiveName = "sessionId"; // sensitive cookie name
        Cookie cookie = new Cookie(sensitiveName, "value");
        // NewCookie constructor with httpOnly false (6th argument in 6-arg version)
        NewCookie newCookie = new NewCookie(cookie, "comment", 3600, null, null, false);
        // NewCookie object converted to string implicitly via toString() in addHeader
        response.addHeader("set-cookie", newCookie.toString()); // no "httponly" substring as compile-time constant
    }
}