// A user-controlled value flows to an expression and the permissions construction is a method call not for permissions check should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase6_Var5 {
    // Simulating a non-permission-check method.
    static void logPermission(String perm) {}

    // Inline the logging call into a wrapper.
    private static void logWrapper(String msg) {
        logPermission(msg);
    }

    public static void main(String[] args) {
        // Variant 5: Taint flows through a chain of calls, none of which are permission checks.
        AnotherClass userInput = new AnotherClass();
        String tainted = userInput.toString();
        logWrapper(tainted);
    }
}