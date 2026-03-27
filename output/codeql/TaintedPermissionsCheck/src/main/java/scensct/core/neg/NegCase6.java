// A user-controlled value flows to an expression and the permissions construction is a method call not for permissions check should not be flagged.
package scensct.core.neg;

import com.exp.AnotherClass;

public class NegCase6 {
    // Simulating a non-permission-check method.
    static void logPermission(String perm) {}

    public static void main(String[] args) {
        // Scenario: user value flows to E, but method is not a permissions check method.
        AnotherClass userInput = new AnotherClass(); // Source.
        String tainted = userInput.toString(); // Expression E.
        logPermission(tainted); // Method call, but not a permissions check method like hasPermission.
    }
}