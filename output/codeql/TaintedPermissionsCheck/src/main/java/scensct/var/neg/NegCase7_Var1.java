// A user-controlled value flows to an expression and the permissions construction is a WildCardPermission constructor where E is not the first argument should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Tainted value obtained via method call chain, then embedded in middle of argument.
        AnotherClass src = new AnotherClass();
        String userData = src.toString();
        String prefix = "static:";
        String suffix = ":end";
        String arg = prefix + userData + suffix; // userData is in middle, not first part.
        WildCardPermission perm = new WildCardPermission(arg);
    }
}