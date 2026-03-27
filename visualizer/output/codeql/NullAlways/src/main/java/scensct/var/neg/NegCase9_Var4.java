// Dereference exists but not in the specific basic block under analysis should not be flagged as always null.
package scensct.var.neg;

public class NegCase9_Var4 {
    // Extract conditional assignment to a helper
    private static Object maybeAssign(boolean cond) {
        return cond ? new Object() : null;
    }

    public static void main(String[] args) {
        Object local = null;
        if (args.length > 0) {
            // nothing
        } else {
            // Assignment via helper
            Object tmp = maybeAssign(args.length < 0);
            if (tmp != null) {
                local = tmp;
            }
            System.out.println(local.toString());
        }
    }
}