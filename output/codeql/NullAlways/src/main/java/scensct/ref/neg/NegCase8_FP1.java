// Second dereference of a non-field variable in same basic block should not be flagged as always null.
package scensct.ref.neg;

public class NegCase8_FP1 {
    public static void main(String[] args) {
        Object local = null;
        // First dereference (would be flagged)
        // System.out.println(local.toString()); // Not included
        // Second dereference in same block
        System.out.println(local.hashCode()); // Not the first dereference // [REPORTED LINE]
    }
}