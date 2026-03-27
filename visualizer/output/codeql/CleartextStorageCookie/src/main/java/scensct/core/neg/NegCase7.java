// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie call from HttpServletResponse is the store but a different cookie is passed should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase7 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Scenario 7: Sensitive cookie created, but a different cookie is passed to addCookie
        Cookie sensitiveCookie = new Cookie("name", sensitiveData);
        Cookie otherCookie = new Cookie("other", "nonSensitive");
        response.addCookie(otherCookie); // Adding a different cookie, not the sensitive one
    }
}