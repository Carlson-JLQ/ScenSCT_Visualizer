// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor but no method call with the name "addCookie" exists should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase4_Var5 {
    public void method(String sensitiveData) {
        // Variant 5: Try-catch around cookie creation, sensitive data from method param
        try {
            Cookie cookie = new Cookie("name", sensitiveData.trim());
        } catch (Exception e) {
            // ignore
        }
        // No addCookie present
    }
}