// A permissions check uses an expression with no taint flow from a user-controlled source should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase3_Var3 {
    // Variant 3: Control flow with branch, but permission string is constant in both paths.
    public static void main(String[] args) {
        AnotherClass source = new AnotherClass(); // Source
        String perm;
        if (System.currentTimeMillis() % 2 == 0) {
            perm = "static:permission";
        } else {
            perm = "static:permission"; // Same literal, different lexical occurrence
        }
        WildCardPermission wcp = new WildCardPermission(perm); // Sink
        // source not involved
    }
}