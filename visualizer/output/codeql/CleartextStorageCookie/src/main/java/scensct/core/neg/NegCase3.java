// A javax.servlet.http.Cookie is constructed with a non-sensitive value argument should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase3 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Scenario 3: No sensitive data flows into the cookie value (second argument)
        String nonSensitiveValue = "publicInfo";
        Cookie cookie = new Cookie("name", nonSensitiveValue);
        response.addCookie(cookie); // Should not trigger because value is not sensitive
    }
}