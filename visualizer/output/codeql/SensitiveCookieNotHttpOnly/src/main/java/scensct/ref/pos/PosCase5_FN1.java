// A sensitive cookie name flows into a Cookie, its toString() used to construct NewCookie with httpOnly false, passed to addCookie without safety should be flagged as positive.
package scensct.ref.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.NewCookie;

public class PosCase5_FN1 {
    public void test(HttpServletResponse response) {
        String sensitiveName = "sessionId"; // sensitive cookie name
        Cookie cookie = new Cookie(sensitiveName, "value");
        cookie.setPath("/");
        // toString() called
        String cookieStr = cookie.toString();
        // Construct NewCookie with httpOnly false (simplified: using a constructor that sets httpOnly false)
        // Using 6-arg constructor with httpOnly false
        NewCookie newCookie = new NewCookie(cookie, "comment", 3600, null, null, false);
        // Not made safe via setHttpOnly(true) or setMaxAge(0) before addCookie
        // Note: NewCookie doesn't have setHttpOnly method; safety is via constructor arguments.
        // The flow: NewCookie object passed to addCookie (though addCookie expects Cookie, not NewCookie).
        // For checker detection, we assume adaptation: converting NewCookie to string and using addHeader.
        // But scenario says passed to addCookie, so we use a wrapper that accepts NewCookie (hypothetical).
        // To keep minimal and compilable, we'll use addHeader as per typical usage.
        response.addHeader("set-cookie", newCookie.toString());
    }
}