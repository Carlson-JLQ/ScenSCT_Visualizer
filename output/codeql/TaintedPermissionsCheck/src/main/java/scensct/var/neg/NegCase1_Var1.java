// A permissions check uses a value that is not from a user-controlled source should not be flagged as tainted permissions vulnerability.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with final and concatenation
        final String base = "admin";
        final String action = "read";
        String constantPermission = base + ":" + action;
        WildCardPermission perm = new WildCardPermission(constantPermission);
    }
}