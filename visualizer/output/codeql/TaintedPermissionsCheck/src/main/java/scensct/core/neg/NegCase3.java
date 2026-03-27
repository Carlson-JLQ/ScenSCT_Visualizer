// A permissions check uses an expression with no taint flow from a user-controlled source should not be flagged.
package scensct.core.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase3 {
    public static void main(String[] args) {
        // Scenario: user source and permission sink exist, but no taint flow between them.
        AnotherClass userInput = new AnotherClass(); // Source S.
        String safePermission = "static:permission"; // Expression E, independent of S.
        WildCardPermission perm = new WildCardPermission(safePermission); // Sink K for E, no flow from S.
    }
}