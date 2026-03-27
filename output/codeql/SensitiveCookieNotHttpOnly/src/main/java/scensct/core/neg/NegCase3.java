// Sensitive cookie name exists but all cookie-setting sinks are not method calls should not be flagged.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

public class NegCase3 {
    public void setCookie(HttpServletResponse response) {
        String name = "authToken"; // Sensitive name
        Cookie cookie = new Cookie(name, "value");
        // Sink is referenced but not invoked as a method call
        Consumer<Cookie> r = response::addCookie; // Method reference, not a call
    }
}