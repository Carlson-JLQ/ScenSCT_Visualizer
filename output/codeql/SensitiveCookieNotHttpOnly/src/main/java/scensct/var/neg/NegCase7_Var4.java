// Sensitive cookie name flows to NewCookie constructor with HttpOnly true should not be flagged.
package scensct.var.neg;

import javax.ws.rs.core.NewCookie;

public class NegCase7_Var4 {
    // Intra-procedural: aliasing and temporary variables for all arguments
    public void createCookie() {
        String sensitive = "session";
        String cookieValue = "value";
        String path = "/";
        String domain = "myapp.com";
        int version = 1;
        String comment = "secure";
        int maxAge = 100;
        java.util.Date expiry = null;
        boolean secure = false;
        boolean httpOnly = true;
        
        // Reorder arguments into variables, then pass
        NewCookie cookie = new NewCookie(
            sensitive, cookieValue, path, domain, version,
            comment, maxAge, expiry, secure, httpOnly
        );
    }
}