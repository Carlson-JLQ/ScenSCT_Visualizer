// Sensitive cookie name exists but all cookie-setting sinks are not method calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

public class NegCase3_Var4 {
    public void setCookie(HttpServletResponse response) {
        // Introduce a temporary and control flow that does not affect the witness
        String key = "authToken";
        Cookie c = null;
        if (key.length() > 0) {
            c = new Cookie(key, "data");
        } else {
            c = new Cookie("default", "x");
        }
        // Method reference stored in a variable that is never used
        final Consumer<Cookie> unusedSink = response::addCookie;
        // No invocation
    }
}