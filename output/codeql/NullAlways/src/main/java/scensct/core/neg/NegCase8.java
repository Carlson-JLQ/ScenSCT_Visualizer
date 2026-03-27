// Second dereference of a non-field variable in same basic block should not be flagged as always null.
package scensct.core.neg;

public class NegCase8 {
    public static void main(String[] args) {
        Object local = null;
        // First dereference (would be flagged)
        // System.out.println(local.toString()); // Not included
        // Second dereference in same block
        // Introduce conditional assignment to evade always-null detection
        if (args.length > 0) {
            local = new Object();
        }
        System.out.println(local.hashCode()); // Not the first dereference // [REPORTED LINE]
    }
}