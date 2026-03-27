// A user-controlled value flows to an expression and the permissions construction is a constructor call not for WildCardPermission should not be flagged.
package scensct.core.neg;

import com.exp.AnotherClass;

public class NegCase5 {
    // Simulating a different permission type constructor.
    static class OtherPermission {
        OtherPermission(String perm) {}
    }

    public static void main(String[] args) {
        // Scenario: user value flows to E, but constructor is not WildCardPermission.
        AnotherClass userInput = new AnotherClass(); // Source.
        String tainted = userInput.toString(); // Expression E.
        OtherPermission perm = new OtherPermission(tainted); // Constructor call, but not WildCardPermission.
    }
}