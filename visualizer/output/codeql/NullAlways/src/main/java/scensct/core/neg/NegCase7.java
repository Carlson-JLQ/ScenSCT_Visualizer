// Dereference in block guarded by null check where variable's ultimate definition is not always null should not be flagged as always null.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        Object local = new Object(); // Ultimate definition non-null
        if (local == null) { // Guard always false
            // Variable known to be non-null in this context
            System.out.println(local.toString());
        }
    }
}