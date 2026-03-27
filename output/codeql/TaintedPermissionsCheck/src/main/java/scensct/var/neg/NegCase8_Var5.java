// A user-controlled value flows to an expression and the permissions construction is a permissions check method where E is not the first argument should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase8_Var5 {
    static boolean hasPermission(String perm, String context) {
        return true;
    }

    // Simulate a permissions check wrapper that still passes taint as second arg
    private static void checkWithLog(String perm, String ctx) {
        System.out.println("Checking: " + perm + " for " + ctx);
        hasPermission(perm, ctx);
    }

    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        // Taint flows through a wrapper method, but remains second argument
        checkWithLog("superuser:all", userInput.toString());
    }
}