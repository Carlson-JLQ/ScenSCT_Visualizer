// Adding a cookie without setting secure flag should be flagged as insecure.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var4 {
    // Variant 4: Try-finally block, cookie created outside try
    public void insecureCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("id", "val");
        try {
            // some operation that doesn't affect cookie
            int x = 1;
        } finally {
            response.addCookie(cookie); // [REPORTED LINE]
        }
    }
}