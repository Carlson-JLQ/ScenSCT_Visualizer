// Sensitive data flows into an argument of a javax.servlet.http.Cookie constructor that is not the second argument (the value) should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase2_Var5 {
    // Variant 5: Use a StringBuilder to construct the name (still sensitive flow)
    public void method(HttpServletResponse response, String sensitiveData) {
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(sensitiveData);
        Cookie cookie = new Cookie(nameBuilder.toString(), "safe");
        response.addCookie(cookie);
    }
}