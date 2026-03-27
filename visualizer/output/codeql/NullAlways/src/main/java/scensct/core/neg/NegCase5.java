// Dereference of a non-field variable guarded by explicit non-null check should not be flagged as always null.
package scensct.core.neg;

public class NegCase5 {
    public static void main(String[] args) {
        Object local = null;
        if (local != null) { // Explicit non-null guard
            // Block guarded by non-null check
            System.out.println(local.toString());
        }
    }
}