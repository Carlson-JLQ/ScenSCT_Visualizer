// A permissions check uses a value that is not from a user-controlled source should not be flagged as tainted permissions vulnerability.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;

public class NegCase1_Var2 {
    // Variant 2: Inter-procedural refactoring - extraction to a helper method
    public static void main(String[] args) {
        WildCardPermission perm = createPermission();
    }
    
    private static WildCardPermission createPermission() {
        String constantPermission = "admin:read";
        return new WildCardPermission(constantPermission);
    }
}