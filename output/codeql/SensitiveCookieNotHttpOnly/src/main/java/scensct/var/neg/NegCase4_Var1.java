// Sensitive cookie name with Set-Cookie header containing HttpOnly should not be flagged.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase4_Var1 {
    public void setHeader(HttpServletResponse response) {
        final String cookieName = "token";
        String headerValue = cookieName + "=value; ";
        headerValue += "HttpOnly";
        response.setHeader("Set-Cookie", headerValue);
    }
}