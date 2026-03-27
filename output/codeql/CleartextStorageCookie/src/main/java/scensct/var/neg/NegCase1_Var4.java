// A Cookie object instantiated via a method other than the javax.servlet.http.Cookie or jakarta.servlet.http.Cookie constructor should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var4 {
    // Variant 4: Introduce a wrapper class that holds the custom cookie, then unwrap it.
    static class CookieHolder {
        com.exp.Cookie cookie;
        CookieHolder(com.exp.Cookie c) { this.cookie = c; }
        com.exp.Cookie get() { return cookie; }
    }

    public void method(HttpServletResponse response, String sensitiveData) {
        CookieHolder holder = new CookieHolder(new com.exp.Cookie("name", sensitiveData));
        response.addCookie(holder.get());
    }
}