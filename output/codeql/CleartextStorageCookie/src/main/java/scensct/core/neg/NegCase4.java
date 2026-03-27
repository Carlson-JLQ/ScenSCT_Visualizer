// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor but no method call with the name "addCookie" exists should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;

public class NegCase4 {
    public void method(String sensitiveData) {
        // Scenario 4: Cookie created with sensitive value but never added via addCookie
        Cookie cookie = new Cookie("name", sensitiveData);
        // No addCookie call present in the code
        // The cookie may be stored or used elsewhere, but no HttpServletResponse addCookie
    }
}