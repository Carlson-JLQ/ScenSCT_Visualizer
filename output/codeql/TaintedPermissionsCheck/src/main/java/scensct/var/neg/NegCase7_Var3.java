// A user-controlled value flows to an expression and the permissions construction is a WildCardPermission constructor where E is not the first argument should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase7_Var3 {
    // Helper to introduce inter-procedural flow
    private static String wrap(String middle) {
        return "fixed:" + middle + ":tail";
    }

    public static void main(String[] args) {
        // Variant 3: Tainted value passed to helper that embeds it non-first.
        AnotherClass src = new AnotherClass();
        String userVal = src.toString();
        String arg = wrap(userVal); // userVal is middle segment.
        WildCardPermission perm = new WildCardPermission(arg);
    }
}