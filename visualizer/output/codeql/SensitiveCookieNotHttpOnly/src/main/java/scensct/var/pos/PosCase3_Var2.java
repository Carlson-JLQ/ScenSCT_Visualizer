// A compile-time constant sensitive cookie name flows into a Cookie, its toString() used to construct a new Cookie passed to addCookie without safety should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var2 {
    // Variant 2: Introduce a redundant string operation on the name, and use a conditional that always passes
    public void test(HttpServletResponse response) {
        final String base = "session";
        String sensitiveName = base + "Id"; // compile-time concatenation
        Cookie cookie1 = new Cookie(sensitiveName, "value");
        cookie1.setPath("/");
        // Simulate some string processing
        String cookieStr = cookie1.toString();
        int length = cookieStr.length();
        Cookie cookie2 = null;
        if (length > 0) { // always true
            cookie2 = new Cookie(sensitiveName, "value");
            cookie2.setPath("/");
        }
        // cookie2 is definitely non-null here
        response.addCookie(cookie2); // [REPORTED LINE]
    }
}