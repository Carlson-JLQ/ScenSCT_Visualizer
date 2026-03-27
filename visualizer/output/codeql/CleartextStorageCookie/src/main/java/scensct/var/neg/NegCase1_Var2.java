// A Cookie object instantiated via a method other than the javax.servlet.http.Cookie or jakarta.servlet.http.Cookie constructor should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var2 {
    // Variant 2: Extract cookie creation into a helper method that returns the custom Cookie type.
    private com.exp.Cookie createCookie(String name, String value) {
        return new com.exp.Cookie(name, value);
    }

    public void method(HttpServletResponse response, String sensitiveData) {
        com.exp.Cookie custom = createCookie("user", sensitiveData);
        response.addCookie(custom);
    }
}