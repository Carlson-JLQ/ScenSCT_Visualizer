// A user-controlled value flows to an expression and the permissions construction is a constructor call not for WildCardPermission should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase5_Var1 {
    static class OtherPermission {
        OtherPermission(String perm) {}
    }

    public static void main(String[] args) {
        // Variant 1: Lexical refactoring – expression split and temporary variable with alias.
        AnotherClass src = new AnotherClass();
        String raw = src.toString();
        String permissionString = raw.trim(); // trivial transformation preserving taint
        OtherPermission p = new OtherPermission(permissionString);
    }
}