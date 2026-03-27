// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie from HttpServletResponse is called but not as the store node in the dataflow should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Scenario 6: Sensitive data flows to cookie value, but addCookie call is not the store node for that dataflow
        Cookie cookie = new Cookie("name", sensitiveData);
        // The addCookie call uses the cookie, but the sensitive data's store node is the cookie constructor, not this call
        response.addCookie(cookie); // The store node for sensitiveData is the Cookie constructor, not addCookie
    }
}