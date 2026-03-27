// A user-controlled value flows to an expression and the permissions construction is a WildCardPermission constructor where E is not the first argument should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase7_Var5 {
    public static void main(String[] args) {
        // Variant 5: Tainted value used in a ternary that chooses a suffix, not prefix.
        AnotherClass src = new AnotherClass();
        String tainted = src.toString();
        String safePrefix = "allow:";
        String arg = safePrefix + (tainted.length() > 5 ? tainted : "default");
        // tainted appears after colon (non‑first) in the concatenated string.
        WildCardPermission perm = new WildCardPermission(arg);
    }
}