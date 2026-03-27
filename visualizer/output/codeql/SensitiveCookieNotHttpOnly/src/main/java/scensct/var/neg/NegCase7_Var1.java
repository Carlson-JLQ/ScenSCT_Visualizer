// Sensitive cookie name flows to NewCookie constructor with HttpOnly true should not be flagged.
package scensct.var.neg;

import javax.ws.rs.core.NewCookie;

public class NegCase7_Var1 {
    public void createCookie() {
        // Lexical refactoring: rename variable, split declaration and assignment
        final String cookieName;
        cookieName = "session";
        // Intra-procedural: use a temporary variable for HttpOnly flag
        boolean secureHttpOnly = true;
        NewCookie cookie = new NewCookie(
            cookieName, "val", "/", "example.com", 1,
            "some comment", 200, null, false, secureHttpOnly
        );
    }
}