// Sensitive cookie name flows to NewCookie constructor with HttpOnly true should not be flagged.
package scensct.var.neg;

import javax.ws.rs.core.NewCookie;

public class NegCase7_Var3 {
    public void createCookie() {
        // Idiomatic variation: use a builder-like pattern via method chaining
        // (though NewCookie has no builder, we simulate with a factory method)
        NewCookie cookie = createSecureSessionCookie("session", "value");
    }
    
    private NewCookie createSecureSessionCookie(String name, String value) {
        // Control flow restructuring: conditional that always takes true branch
        boolean isProduction = true;
        if (isProduction) {
            return new NewCookie(
                name, value, "/", "prod-domain", 1,
                "prod comment", 300, null, false, true
            );
        } else {
            // Dead code, but preserves structure
            return new NewCookie(
                name, value, "/", "test-domain", 1,
                "test comment", 0, null, false, false
            );
        }
    }
}