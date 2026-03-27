// Sensitive cookie name exists but all cookie-setting sinks are not method calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

public class NegCase3_Var1 {
    public void setCookie(HttpServletResponse response) {
        // Lexical refactoring: split declaration, rename, same pattern
        final String sensitiveName = "authToken";
        Cookie c = new Cookie(sensitiveName, "value");
        // Still a method reference, not a call
        Consumer<Cookie> sink = response::addCookie;
    }
}