// A compile-time constant sensitive cookie name passed to Cookie then NewCookie with httpOnly false, passed to addCookie without safety should be flagged as positive.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

public class PosCase6 {
    public void test() {
        // compile-time constant sensitive name
        Cookie cookie = new Cookie("userToken", "value");
        // NewCookie constructor with httpOnly false (6-arg version)
        NewCookie newCookie = new NewCookie(cookie, "comment", 3600, null, null, false);
        // Use JAX-RS Response builder to set cookie, which accepts NewCookie
        Response response = Response.ok().cookie(newCookie).build();
    }
}