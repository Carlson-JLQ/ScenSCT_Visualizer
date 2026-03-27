// Sensitive cookie name flows to NewCookie constructor with HttpOnly true should not be flagged.
package scensct.core.neg;

import javax.ws.rs.core.NewCookie;

public class NegCase7 {
    public void createCookie() {
        String sensitiveName = "session";
        // NewCookie constructor with 10 arguments, 10th (HttpOnly) is true
        NewCookie cookie = new NewCookie(
            sensitiveName, "value", "/", "domain", 1, "comment",
            100, null, false, true // true for HttpOnly
        );
        // No sink call required as NewCookie construction itself may be considered safe
    }
}