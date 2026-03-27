// A permissions check uses a value that is not from a user-controlled source should not be flagged as tainted permissions vulnerability.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;

public class NegCase1_Var3 {
    // Variant 3: Idiomatic variation using StringBuilder (still constant)
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("admin");
        sb.append(':');
        sb.append("read");
        String constantPermission = sb.toString();
        WildCardPermission perm = new WildCardPermission(constantPermission);
    }
}