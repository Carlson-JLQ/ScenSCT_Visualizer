// Sensitive data flows into an argument of a javax.servlet.http.Cookie constructor that is not the second argument (the value) should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase2 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Scenario 2: Sensitive data flows into the first argument (name), not the value
        Cookie cookie = new Cookie(sensitiveData, "nonSensitiveValue");
        response.addCookie(cookie); // Should not trigger because sensitive data is in name, not value
    }
}