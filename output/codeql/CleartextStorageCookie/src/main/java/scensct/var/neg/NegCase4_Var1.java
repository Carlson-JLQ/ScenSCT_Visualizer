// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor but no method call with the name "addCookie" exists should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase4_Var1 {
    public void method(String sensitiveData) {
        // Variant 1: Introduce an alias via a local variable
        String value = sensitiveData;
        Cookie cookie = new Cookie("name", value);
        // Still no addCookie
    }
}