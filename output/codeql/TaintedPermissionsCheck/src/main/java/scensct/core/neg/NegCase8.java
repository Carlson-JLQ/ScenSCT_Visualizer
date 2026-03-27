// A user-controlled value flows to an expression and the permissions construction is a permissions check method where E is not the first argument should not be flagged.
package scensct.core.neg;

import com.exp.AnotherClass;

public class NegCase8 {
    // Simulating a permissions check method (e.g., hasPermission).
    static boolean hasPermission(String perm, String context) {
        return true;
    }

    public static void main(String[] args) {
        // Scenario: user value flows to E, but E is not the first argument of the permissions check method.
        AnotherClass userInput = new AnotherClass(); // Source.
        String tainted = userInput.toString(); // Expression E.
        // Permissions check method call with E as second argument.
        hasPermission("admin:read", tainted); // E is second argument, not first.
    }
}