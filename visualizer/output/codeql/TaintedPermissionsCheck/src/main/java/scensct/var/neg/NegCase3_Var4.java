// A permissions check uses an expression with no taint flow from a user-controlled source should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase3_Var4 {
    // Variant 4: Permission string built via concatenation of literals, still safe.
    public static void main(String[] args) {
        AnotherClass input = new AnotherClass(); // Source present
        String base = "static:";
        String action = "permission";
        String fullPermission = base + action; // Literal concatenation
        WildCardPermission perm = new WildCardPermission(fullPermission); // Sink
        // input remains isolated
    }
}