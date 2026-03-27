// A permissions check uses a value that is not from a user-controlled source should not be flagged as tainted permissions vulnerability.
package scensct.core.neg;

import org.apache.shiro.authz.permission.WildCardPermission;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario: permission constructed from a constant string, not user-controlled.
        String constantPermission = "admin:read";
        WildCardPermission perm = new WildCardPermission(constantPermission); // No user source.
    }
}