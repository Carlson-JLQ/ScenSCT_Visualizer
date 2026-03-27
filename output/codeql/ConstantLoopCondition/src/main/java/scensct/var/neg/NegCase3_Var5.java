// Loop condition same at re-entry via expected expression but re-entry not from body should not be flagged.
package scensct.var.neg;

public class NegCase3_Var5 {
    // Inter-procedural: extract update logic to a helper
    private static int increment(int val) {
        return val + 1;
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            i = increment(i); // Update via method call
        }
    }
}