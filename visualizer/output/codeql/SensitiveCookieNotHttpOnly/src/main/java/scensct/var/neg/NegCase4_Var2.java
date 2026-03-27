// Sensitive cookie name with Set-Cookie header containing HttpOnly should not be flagged.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase4_Var2 {
    public void setHeader(HttpServletResponse response) {
        String sensitive = "token";
        StringBuilder sb = new StringBuilder();
        sb.append(sensitive).append("=value; HttpOnly");
        response.setHeader("Set-Cookie", sb.toString());
    }
}