// Sensitive data flows into an argument of a javax.servlet.http.Cookie constructor that is not the second argument (the value) should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase2_Var4 {
    // Variant 4: Inline the constructor call with a ternary expression in name argument
    public void method(HttpServletResponse response, String sensitiveData) {
        response.addCookie(
            new Cookie(sensitiveData != null ? sensitiveData : "fallback", "value")
        );
    }
}