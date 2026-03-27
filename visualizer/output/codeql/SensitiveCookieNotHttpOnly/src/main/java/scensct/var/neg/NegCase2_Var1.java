// Sensitive cookie name exists but no cookie-setting sink calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase2_Var1 {
    private static final String SENSITIVE_TOKEN = "sessionId";
    
    public void process() {
        String name = SENSITIVE_TOKEN;
        String cookieName = name;
        Cookie c = new Cookie(cookieName, "value");
        // Still no sink call
    }
}