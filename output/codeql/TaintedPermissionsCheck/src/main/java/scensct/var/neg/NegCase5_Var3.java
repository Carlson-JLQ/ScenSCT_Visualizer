// A user-controlled value flows to an expression and the permissions construction is a constructor call not for WildCardPermission should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase5_Var3 {
    static class OtherPermission {
        OtherPermission(String perm) {}
    }

    // Variant 3: Inter-procedural – extract taint source to helper method.
    private static String getUserControlledString() {
        return new AnotherClass().toString();
    }

    public static void main(String[] args) {
        String tainted = getUserControlledString();
        OtherPermission perm = new OtherPermission(tainted);
    }
}