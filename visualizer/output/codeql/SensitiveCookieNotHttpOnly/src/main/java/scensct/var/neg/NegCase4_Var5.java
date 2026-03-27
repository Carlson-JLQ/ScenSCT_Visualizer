// Sensitive cookie name with Set-Cookie header containing HttpOnly should not be flagged.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase4_Var5 {
    private void setCookieHeader(HttpServletResponse resp, String name, String value, boolean httpOnly) {
        String header = name + "=" + value + ";";
        if (httpOnly) {
            header += " HttpOnly";
        }
        resp.setHeader("Set-Cookie", header);
    }

    public void setHeader(HttpServletResponse response) {
        setCookieHeader(response, "token", "value", true);
    }
}