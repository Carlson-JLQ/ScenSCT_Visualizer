// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie call from HttpServletResponse is the store but a different cookie is passed should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase7_Var2 {
    // Variant 2: Extract sensitive cookie creation into a helper that returns it,
    // but still add a different cookie.
    private Cookie makeSensitiveCookie(String data) {
        return new Cookie("name", data);
    }

    public void method(HttpServletResponse response, String sensitiveData) {
        Cookie c1 = makeSensitiveCookie(sensitiveData);
        Cookie c2 = new Cookie("other", "nonSensitive");
        response.addCookie(c2);
    }
}