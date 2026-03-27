// A user-controlled value flows to an expression and the permissions construction is a method call not for permissions check should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase6_Var2 {
    // Simulating a non-permission-check method.
    static void logPermission(String perm) {}

    // Helper extraction: move taint propagation to a separate method.
    private static String getUserData(AnotherClass input) {
        return input.toString();
    }

    public static void main(String[] args) {
        // Variant 2: Inter-procedural - taint flows through a helper.
        AnotherClass userInput = new AnotherClass();
        String tainted = getUserData(userInput);
        logPermission(tainted);
    }
}