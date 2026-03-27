// A compile-time constant sensitive cookie name flows into a Cookie, its toString() used to construct a new Cookie passed to addCookie without safety should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var4 {
    // Variant 4: Use an array of cookies, but only the sensitive one is added
    public void test(HttpServletResponse response) {
        String[] names = { "sessionId", "nonSensitive" };
        Cookie[] cookies = new Cookie[2];
        for (int i = 0; i < names.length; i++) {
            cookies[i] = new Cookie(names[i], "val" + i);
            cookies[i].setPath("/");
        }
        // Only add the sensitive one (index 0)
        response.addCookie(cookies[0]); // [REPORTED LINE]
    }
}