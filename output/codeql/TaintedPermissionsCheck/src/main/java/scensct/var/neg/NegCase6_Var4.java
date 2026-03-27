// A user-controlled value flows to an expression and the permissions construction is a method call not for permissions check should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase6_Var4 {
    // Simulating a non-permission-check method.
    static void logPermission(String perm) {}

    public static void main(String[] args) {
        // Variant 4: Introduce irrelevant intermediate operations (string concatenation).
        AnotherClass userInput = new AnotherClass();
        String base = userInput.toString();
        String tainted = base + ""; // No semantic change.
        logPermission(tainted);
    }
}