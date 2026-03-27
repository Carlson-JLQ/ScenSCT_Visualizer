// A permissions check uses an expression with no taint flow from a user-controlled source should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase3_Var5 {
    // Variant 5: Try-catch block with safe permission, source exists but unused in sink.
    public static void main(String[] args) {
        AnotherClass userSource = new AnotherClass(); // Source
        String safe = null;
        try {
            safe = "static:permission"; // Assignment in try block
        } catch (Exception e) {
            safe = "static:permission"; // Same fallback
        } finally {
            // Ensure safe is set
        }
        WildCardPermission perm = new WildCardPermission(safe); // Sink
        // userSource never flows into safe
    }
}