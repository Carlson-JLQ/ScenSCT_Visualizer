// A permissions check uses a value that is not from a user-controlled source should not be flagged as tainted permissions vulnerability.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;

public class NegCase1_Var5 {
    // Variant 5: Intra-procedural with temporary variable and try-catch (no effect)
    public static void main(String[] args) {
        String constantPermission = "admin:read";
        try {
            // Some dummy operation that doesn't affect the string
            constantPermission.trim();
        } catch (Exception e) {
            // Ignore
        }
        WildCardPermission perm = new WildCardPermission(constantPermission);
    }
}