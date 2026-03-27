// Dereference exists but not in the specific basic block under analysis should not be flagged as always null.
package scensct.var.neg;

public class NegCase9_Var2 {
    public static void main(String[] args) {
        Object local = null;
        // Introduce a temporary alias
        Object ref = local;
        if (args.length > 0) {
            // no-op
        } else {
            if (args.length < 0) {
                ref = new Object();
                local = ref; // assignment through alias
            }
            System.out.println(local.toString());
        }
    }
}