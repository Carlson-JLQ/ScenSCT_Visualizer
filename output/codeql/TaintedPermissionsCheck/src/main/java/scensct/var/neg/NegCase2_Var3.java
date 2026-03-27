// A user-controlled source exists but no data flow sink node for permissions construction should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase2_Var3 {
    private static void logMessage(String msg) {
        // Helper method that does not involve permissions.
        System.err.println("[LOG] " + msg);
    }

    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        String processed = userInput.toString();
        // Inter-procedural: moving output to a helper.
        logMessage(processed);
    }
}