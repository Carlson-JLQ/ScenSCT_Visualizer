// A user-controlled value flows to an expression and the permissions construction is a permissions check method where E is not the first argument should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase8_Var4 {
    static boolean hasPermission(String perm, String context) {
        return true;
    }

    // Wrap in try-catch, taint flows through assignment in try block
    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        String tainted = null;
        try {
            tainted = String.valueOf(userInput); // different way to get string
        } catch (Exception e) {
            tainted = "default";
        }
        // Second argument
        hasPermission("admin:delete", tainted);
    }
}