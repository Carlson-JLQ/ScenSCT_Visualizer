// Dereference in block guarded by null check where variable's ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase7_Var4 {
    public static void main(String[] args) {
        Object local = new Object();
        // Nested if with redundant conditions
        if (local != null) {
            if (local == null) { // Always false inside outer true branch
                System.out.println(local.toString());
            }
        }
    }
}