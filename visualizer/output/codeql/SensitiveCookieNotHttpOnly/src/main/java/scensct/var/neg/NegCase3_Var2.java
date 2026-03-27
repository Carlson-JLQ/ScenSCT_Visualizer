// Sensitive cookie name exists but all cookie-setting sinks are not method calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

public class NegCase3_Var2 {
    public void setCookie(HttpServletResponse response) {
        String tokenName = "authToken";
        Cookie cookie = new Cookie(tokenName, "someValue");
        // Use lambda instead of method reference (still no invocation here)
        Consumer<Cookie> action = (Cookie c) -> response.addCookie(c);
        // The lambda is defined but not invoked
    }
}