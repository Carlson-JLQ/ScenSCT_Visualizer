// A javax.servlet.http.Cookie is constructed with a non-sensitive value argument should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase3_Var5 {
    public void method(HttpServletResponse response, String sensitiveData) {
        String a = "publicInfo";
        String b = a;
        String c = b + "";
        String nonSensitiveValue = c;
        Cookie cookie = new Cookie("name", nonSensitiveValue);
        HttpServletResponse respAlias = response;
        respAlias.addCookie(cookie);
    }
}