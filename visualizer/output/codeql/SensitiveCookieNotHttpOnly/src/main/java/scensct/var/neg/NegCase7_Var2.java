// Sensitive cookie name flows to NewCookie constructor with HttpOnly true should not be flagged.
package scensct.var.neg;

import javax.ws.rs.core.NewCookie;

public class NegCase7_Var2 {
    // Inter-procedural refactoring: extract cookie name to a helper method
    private String getSensitiveCookieName() {
        return "session";
    }
    
    // Extract NewCookie creation to a method that ensures HttpOnly true
    private NewCookie buildSecureCookie(String name, String value) {
        return new NewCookie(
            name, value, "/", "domain", 1,
            "comment", 100, null, false, true
        );
    }
    
    public void createCookie() {
        String name = getSensitiveCookieName();
        NewCookie cookie = buildSecureCookie(name, "value");
    }
}