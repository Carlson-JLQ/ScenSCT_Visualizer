// A permissions check uses an expression with no taint flow from a user-controlled source should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce an alias and a temporary variable, but keep permission static.
        AnotherClass src = new AnotherClass(); // Source
        String permissionString = "static:permission";
        String alias = permissionString; // Alias, still safe
        WildCardPermission perm = new WildCardPermission(alias); // Sink uses alias
        // src is never used in permission construction
    }
}