// A user-controlled value flows to an expression and the permissions construction is a permissions check method where E is not the first argument should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase8_Var3 {
    static boolean hasPermission(String perm, String context) {
        return true;
    }

    // Inline the taint source into a more complex expression
    public static void main(String[] args) {
        // Tainted value built via concatenation, still second argument
        hasPermission("guest:view", new AnotherClass().toString() + "#" + args.length);
    }
}