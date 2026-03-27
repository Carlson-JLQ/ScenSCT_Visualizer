// A compile-time constant sensitive cookie name passed to Cookie constructor flows to addHeader without httponly should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var4 {
    // Variant 4: Idiomatic variation - use StringBuilder to construct header (still no httponly)
    public void test(HttpServletResponse response) {
        Cookie cookie = new Cookie("authToken", "value");
        cookie.setPath("/");
        StringBuilder sb = new StringBuilder();
        sb.append("set-cookie: ").append(cookie.toString());
        // Simulating manual header addition via string manipulation
        // but still using addHeader with the same cookie string
        response.addHeader("set-cookie", cookie.toString()); // [REPORTED LINE]
    }
}