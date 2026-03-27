// Dereference in block guarded by null check where variable's ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase7_Var3 {
    public static void main(String[] args) {
        Object local = new Object();
        // Use a while loop with false condition
        while (local == null) {
            System.out.println(local.toString());
            break; // Never reached
        }
    }
}