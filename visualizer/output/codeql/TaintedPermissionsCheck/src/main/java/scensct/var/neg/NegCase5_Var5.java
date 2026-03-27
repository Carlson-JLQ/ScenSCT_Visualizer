// A user-controlled value flows to an expression and the permissions construction is a constructor call not for WildCardPermission should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase5_Var5 {
    static class OtherPermission {
        OtherPermission(String perm) {}
    }

    // Variant 5: Loop restructuring – taint assigned in loop that runs exactly once.
    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        String tainted = null;
        for (int i = 0; i < 1; i++) {
            tainted = userInput.toString();
        }
        OtherPermission perm = new OtherPermission(tainted);
    }
}