// Sensitive cookie name exists but no cookie-setting sink calls should not be flagged.
package scensct.core.neg;

import javax.servlet.http.Cookie;

public class NegCase2 {
    public void process() {
        // Sensitive name "sessionId" exists but never flows to a sink
        String cookieName = "sessionId";
        Cookie cookie = new Cookie(cookieName, "value");
        // No addHeader, setHeader, or addCookie calls present
    }
}