// A compile-time constant sensitive cookie name passed to Cookie then NewCookie with httpOnly false, passed to addCookie without safety should be flagged as positive.
package scensct.ref.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.NewCookie;

public class PosCase6_FN1 {
    public void test(HttpServletResponse response) {
        // compile-time constant sensitive name
        Cookie cookie = new Cookie("userToken", "value");
        // NewCookie constructor with httpOnly false (6-arg version)
        NewCookie newCookie = new NewCookie(cookie, "comment", 3600, null, null, false);
        // Not made safe via setHttpOnly(true) or setMaxAge(0) before addCookie
        // Similar adaptation as PosCase5 for compilability
        response.addHeader("set-cookie", newCookie.toString());
    }
}