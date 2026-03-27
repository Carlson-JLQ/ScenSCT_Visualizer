// Null guard in same basic block makes V non-null on path to dereference should not be flagged as potential null pointer dereference.
package scensct.core.neg;

public class NegCase5 {
    public static void main(String[] args) {
        String v = null; // Source: V may be null
        if (v == null) {
            v = "guarded non-null"; // Null guard reassigns V to non-null
        }
        // In this basic block, V is non-null due to guard
        System.out.println(v.length()); // Dereference: V is non-null here
    }
}