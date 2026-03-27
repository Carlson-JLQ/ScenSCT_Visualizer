// A sensitive cookie name flows into a Cookie, its toString() used to construct NewCookie with httpOnly false, passed to addCookie without safety should be flagged as positive.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

public class PosCase5 {
    public void test() {
        String sensitiveName = "sessionId"; // sensitive cookie name
        Cookie cookie = new Cookie(sensitiveName, "value");
        cookie.setPath("/");
        // toString() called
        String cookieStr = cookie.toString();
        // Construct NewCookie with httpOnly false (using the same constructor)
        NewCookie newCookie = new NewCookie(cookie, "comment", 3600, null, null, false);
        // Use JAX-RS Response builder to set cookie
        Response response = Response.ok().cookie(newCookie).build();
    }
}