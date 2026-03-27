// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor but no method call with the name "addCookie" exists should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase4_Var3 {
    // Variant 3: Extract cookie creation to a helper method that returns Cookie
    private Cookie makeCookie(String data) {
        return new Cookie("sessionId", data);
    }
    
    public void method(String sensitiveData) {
        Cookie c = makeCookie(sensitiveData);
        // No addCookie call
    }
}