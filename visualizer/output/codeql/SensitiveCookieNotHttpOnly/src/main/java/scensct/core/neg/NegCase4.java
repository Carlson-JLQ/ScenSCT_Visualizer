// Sensitive cookie name with Set-Cookie header containing HttpOnly should not be flagged.
package scensct.core.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase4 {
    public void setHeader(HttpServletResponse response) {
        String sensitiveName = "token";
        // Set-Cookie header includes HttpOnly flag
        response.setHeader("Set-Cookie", sensitiveName + "=value; HttpOnly");
    }
}