// Sensitive cookie name flows to NewCookie constructor with HttpOnly true should not be flagged.
package scensct.var.neg;

import javax.ws.rs.core.NewCookie;

public class NegCase7_Var5 {
    // Inter-procedural: split constructor arguments across multiple helpers
    private String provideName() { return "session"; }
    private String provideValue() { return "value"; }
    private boolean provideHttpOnly() { return true; }
    
    public void createCookie() {
        // Combine helpers directly in constructor call
        NewCookie cookie = new NewCookie(
            provideName(),
            provideValue(),
            "/",
            "domain",
            1,
            "comment",
            100,
            null,
            false,
            provideHttpOnly()  // HttpOnly true from helper
        );
    }
}