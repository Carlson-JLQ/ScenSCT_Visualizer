// Sensitive cookie name with Set-Cookie header containing HttpOnly should not be flagged.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase4_Var4 {
    public void setHeader(HttpServletResponse response) {
        String cookieName = "token";
        String headerValue = String.format("%s=value; HttpOnly", cookieName);
        response.setHeader("Set-Cookie", headerValue);
    }
}