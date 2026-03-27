// Sensitive cookie name exists but all cookie-setting sinks are not method calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

public class NegCase3_Var3 {
    // Helper method that returns the Consumer (method reference)
    private Consumer<Cookie> getCookieInserter(HttpServletResponse resp) {
        return resp::addCookie;
    }

    public void setCookie(HttpServletResponse response) {
        String name = "authToken";
        Cookie cookie = new Cookie(name, "val");
        // Assign via helper — still just a reference
        Consumer<Cookie> ref = getCookieInserter(response);
        // No call to accept()
    }
}