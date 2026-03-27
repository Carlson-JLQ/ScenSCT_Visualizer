// A Cookie object instantiated via a method other than the javax.servlet.http.Cookie or jakarta.servlet.http.Cookie constructor should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var3 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 3: Use a loop to obscure the flow, but the loop runs exactly once.
        com.exp.Cookie cookie = null;
        for (int i = 0; i < 1; i++) {
            cookie = new com.exp.Cookie("token", sensitiveData + i); // i is 0
        }
        if (cookie != null) {
            response.addCookie(cookie);
        }
    }
}