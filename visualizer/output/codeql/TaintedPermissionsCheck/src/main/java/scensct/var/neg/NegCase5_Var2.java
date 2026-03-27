// A user-controlled value flows to an expression and the permissions construction is a constructor call not for WildCardPermission should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase5_Var2 {
    static class OtherPermission {
        OtherPermission(String perm) {}
    }

    // Variant 2: Intra-procedural – control flow with branch that always takes same path.
    public static void main(String[] args) {
        AnotherClass input = new AnotherClass();
        String tainted = null;
        if (args.length >= 0) { // always true
            tainted = input.toString();
        } else {
            tainted = "constant";
        }
        OtherPermission perm = new OtherPermission(tainted);
    }
}