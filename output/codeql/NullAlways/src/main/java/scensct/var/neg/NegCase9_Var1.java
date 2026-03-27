// Dereference exists but not in the specific basic block under analysis should not be flagged as always null.
package scensct.var.neg;

public class NegCase9_Var1 {
    public static void main(String[] args) {
        Object local = null;
        // Invert condition, same logic
        if (args.length <= 0) {
            // Move conditional assignment into the same outer block as dereference
            if (args.length < 0) {
                local = new Object();
            }
            System.out.println(local.toString());
        } else {
            // Then block empty
        }
    }
}