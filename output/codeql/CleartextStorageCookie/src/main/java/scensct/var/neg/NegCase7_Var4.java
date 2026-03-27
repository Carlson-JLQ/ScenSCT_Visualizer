// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie call from HttpServletResponse is the store but a different cookie is passed should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase7_Var4 {
    // Variant 4: Inline the addCookie call inside a wrapper method,
    // but pass the non‑sensitive cookie.
    private void safeAddCookie(HttpServletResponse resp, Cookie c) {
        resp.addCookie(c);
    }

    public void method(HttpServletResponse response, String sensitiveData) {
        Cookie sensitiveCookie = new Cookie("name", sensitiveData);
        Cookie otherCookie = new Cookie("other", "nonSensitive");
        safeAddCookie(response, otherCookie);
    }
}