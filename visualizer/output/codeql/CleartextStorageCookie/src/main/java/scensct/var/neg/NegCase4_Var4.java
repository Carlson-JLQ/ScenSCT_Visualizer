// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor but no method call with the name "addCookie" exists should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase4_Var4 {
    public void method(String sensitiveData) {
        // Variant 4: Cookie stored in array, no addCookie
        Cookie[] cookies = new Cookie[1];
        cookies[0] = new Cookie("name", sensitiveData);
        // Still no HttpServletResponse in scope
    }
}