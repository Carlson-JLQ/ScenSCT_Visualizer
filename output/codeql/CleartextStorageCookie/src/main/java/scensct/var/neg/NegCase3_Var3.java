// A javax.servlet.http.Cookie is constructed with a non-sensitive value argument should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase3_Var3 {
    public void method(HttpServletResponse response, String sensitiveData) {
        String nonSensitiveValue = makeNonSensitive();
        addCookieWithValue(response, nonSensitiveValue);
    }

    private String makeNonSensitive() {
        return "publicInfo";
    }

    private void addCookieWithValue(HttpServletResponse resp, String value) {
        Cookie cookie = new Cookie("name", value);
        resp.addCookie(cookie);
    }
}