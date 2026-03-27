// A sensitive cookie name flows into Cookie then NewCookie constructor with httpOnly false, NewCookie converted to string used in addHeader without httponly should be flagged as positive.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

public class PosCase4 {
    public void test() {
        String sensitiveName = "sessionId"; // sensitive cookie name
        Cookie cookie = new Cookie(sensitiveName, "value");
        // NewCookie constructor with httpOnly false (6th argument in 6-arg version)
        NewCookie newCookie = new NewCookie(cookie, "comment", 3600, null, null, false);
        // Use JAX-RS Response builder to set cookie
        Response response = Response.ok().cookie(newCookie).build();
    }
}