// A javax.servlet.http.Cookie is constructed with a non-sensitive value argument should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase3_Var4 {
    public void method(HttpServletResponse response, String sensitiveData) {
        String base = "publicInfoXYZ";
        String nonSensitiveValue = base.substring(0, 10); // "publicInfo"
        Cookie cookie = new Cookie("name", nonSensitiveValue);
        try {
            // some operation that doesn't affect cookie
            int dummy = 1;
        } finally {
            response.addCookie(cookie);
        }
    }
}