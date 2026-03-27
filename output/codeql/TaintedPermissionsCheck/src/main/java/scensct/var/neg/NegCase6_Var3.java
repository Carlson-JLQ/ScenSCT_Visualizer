// A user-controlled value flows to an expression and the permissions construction is a method call not for permissions check should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase6_Var3 {
    // Simulating a non-permission-check method.
    static void logPermission(String perm) {}

    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring - tainted value passes through a conditional branch.
        AnotherClass userInput = new AnotherClass();
        String tainted = userInput.toString();
        boolean flag = true;
        if (flag) {
            logPermission(tainted);
        } else {
            logPermission("static-safe");
        }
    }
}