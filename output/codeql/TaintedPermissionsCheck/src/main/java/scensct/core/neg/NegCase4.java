// A user-controlled value flows to an expression but the permissions construction is not a method/constructor call should not be flagged.
package scensct.core.neg;

import com.exp.AnotherClass;

public class NegCase4 {
    public static void main(String[] args) {
        // Scenario: user value flows to E, but P is not a permission check call.
        AnotherClass userInput = new AnotherClass(); // Source.
        String tainted = userInput.toString(); // Expression E receives flow.
        Object notPermission = tainted; // P is an assignment, not a permission constructor/method.
    }
}