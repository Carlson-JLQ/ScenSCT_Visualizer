// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor but no method call with the name "addCookie" exists should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase4_Var2 {
    public void method(String sensitiveData) {
        // Variant 2: Wrap cookie creation in a conditional branch
        if (System.currentTimeMillis() > 0) {
            Cookie cookie = new Cookie("name", sensitiveData);
        } else {
            // dead branch, no cookie created here
        }
        // No addCookie anywhere
    }
}