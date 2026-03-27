// Sensitive cookie name with Set-Cookie header containing HttpOnly should not be flagged.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase4_Var3 {
    public void setHeader(HttpServletResponse response) {
        String name = "token";
        String flag = "HttpOnly";
        // Simulate a conditional that always adds the flag
        boolean secure = true;
        String header = name + "=value;";
        if (secure) {
            header += " " + flag;
        } else {
            header += " Insecure";
        }
        response.setHeader("Set-Cookie", header);
    }
}