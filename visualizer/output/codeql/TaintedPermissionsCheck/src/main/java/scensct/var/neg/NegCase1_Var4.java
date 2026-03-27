// A permissions check uses a value that is not from a user-controlled source should not be flagged as tainted permissions vulnerability.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;

public class NegCase1_Var4 {
    // Variant 4: Static final field and control-flow restructuring
    private static final String PERM_STRING = "admin:read";
    
    public static void main(String[] args) {
        String constantPermission;
        if (System.currentTimeMillis() > 0) { // always true, but non-trivial flow
            constantPermission = PERM_STRING;
        } else {
            constantPermission = "dummy";
        }
        WildCardPermission perm = new WildCardPermission(constantPermission);
    }
}