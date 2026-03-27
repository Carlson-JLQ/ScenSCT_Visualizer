// A user-controlled value flows to an expression and the permissions construction is a permissions check method where E is not the first argument should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase8_Var2 {
    static boolean hasPermission(String perm, String context) {
        return true;
    }

    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        String tainted = userInput.toString();
        // Introduce a conditional that doesn't affect the taint flow
        if (args.length > 0) {
            tainted = tainted + "";
        } else {
            tainted = new String(tainted);
        }
        // Still second argument
        hasPermission("user:edit", tainted);
    }
}