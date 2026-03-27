// Sensitive cookie name exists but no cookie-setting sink calls should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase2_Var3 {
    public void process() {
        Cookie c = makeCookie("sessionId", "value");
        // c is never used in a sink
    }
    
    private Cookie makeCookie(String name, String val) {
        return new Cookie(name, val);
    }
}