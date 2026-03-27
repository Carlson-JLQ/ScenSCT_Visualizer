// Sensitive cookie name exists but no cookie-setting sink calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase2_Var2 {
    public void process() {
        String cookieName = "sessionId";
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                Cookie cookie = new Cookie(cookieName, "value" + i);
            } else {
                // do nothing with cookie
            }
        }
        // No addCookie or related sink
    }
}