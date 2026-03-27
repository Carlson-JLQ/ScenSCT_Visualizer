// A user-controlled value flows to an expression and the permissions construction is a permissions check method where E is not the first argument should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase8_Var1 {
    static boolean hasPermission(String perm, String context) {
        return true;
    }

    // Helper to get tainted value
    private static String getContext(AnotherClass src) {
        return src.toString();
    }

    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        // Taint flows through a helper method, still second argument
        hasPermission("admin:write", getContext(userInput));
    }
}