// Sensitive cookie name exists but no cookie-setting sink calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase2_Var5 {
    public void process(HttpServletResponse response) {
        String cookieName = "sessionId";
        Cookie cookie = new Cookie(cookieName, "value");
        
        // Dead code: sink exists but unreachable
        if (Boolean.FALSE) {
            response.addCookie(cookie); // never executed // [REPORTED LINE]
        }
        // Real execution never calls a sink
    }
}