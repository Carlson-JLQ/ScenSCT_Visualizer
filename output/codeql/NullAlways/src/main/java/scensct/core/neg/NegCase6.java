// Dereference in block guarded by null check where variable is known non-null (unreachable) should not be flagged as always null.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        Object local = new Object(); // Known non-null
        if (local == null) { // Guard always false, block unreachable
            // Unreachable block - dereference should not be flagged
            System.out.println(local.toString());
        }
    }
}